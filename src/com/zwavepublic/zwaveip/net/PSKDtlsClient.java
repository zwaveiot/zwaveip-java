/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zwavepublic.zwaveip.net;

import java.io.IOException;
import java.util.EventObject;

import org.bouncycastle.tls.AlertLevel;
import org.bouncycastle.tls.AlertDescription;
import org.bouncycastle.tls.CipherSuite;
import org.bouncycastle.tls.PSKTlsClient;
import org.bouncycastle.tls.ProtocolVersion;
import org.bouncycastle.tls.TlsPSKIdentity;
import org.bouncycastle.tls.TlsSession;
import org.bouncycastle.tls.TlsUtils;
import org.bouncycastle.tls.crypto.TlsCrypto;

/* This class provides the parameters of our DTLS connection (PSK identity and password, supported 
 * ciphersuites, supported DTLS versions, etc.) to BouncyCastle upon request and also stores an up-to-date
 * reference to the current DTLS session. This class is support infrastructure for BouncyCastle. */

public class PSKDtlsClient extends PSKTlsClient {
	// event plumbing
    interface RemoteSocketListener {
    	void remoteSocketClosed(EventObject source);
    }
    RemoteSocketListener socketRemoteCloseListener = null;

	/* NOTE: BouncyCastle's DTLSClientProtocol class will also automatically add TLS_EMPTY_RENEGOTIATION_INFO_SCSV (RFC 5746) unless
	 *       we offer an empty "renegotiation_info" extension. */
	private static final int[] ZIP_CIPHER_SUITES = new int[] {
		    CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA,
		    CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA,						
	};
	private int[] supportedCipherSuites;
	
	// NOTE: we keep a reference to our DTLS session once it is established (for continued use, for session resumption purposes, etc.)
	protected TlsSession dtlsSession;

	/* constructor: initialize our PSKTlsClient superclass with the provided crypto and PSK identity;
	 * this constructor overload is used if a DTLS session is not yet established. */
	public PSKDtlsClient(TlsCrypto crypto, TlsPSKIdentity pskIdentity) {
		this(crypto, pskIdentity, null);
	}

	/* constructor: initialize our PSKTlsClient superclass with the provided crypto and PSK identity;
	 * this constructor overload is used when a DTLS session is already established, as it also caches
	 * the established DTLS session (for continued use, for session resumption purposes, etc.) */
    public PSKDtlsClient(TlsCrypto crypto, TlsPSKIdentity pskIdentity, TlsSession dtlsSession)
    {
    	super(crypto, pskIdentity);
        this.supportedCipherSuites = TlsUtils.getSupportedCipherSuites(crypto, ZIP_CIPHER_SUITES);
        this.dtlsSession = dtlsSession;
    }

    /*** PSKTlsClient overrides ***/
    
    @Override
    public int[] getCipherSuites() {
		return this.supportedCipherSuites.clone();
    }
    
    /*** AbstractTlsClient overrides ***/
    
    @Override
    public TlsSession getSessionToResume()
    {
        return this.dtlsSession;
    }
    
    @Override
    public ProtocolVersion getClientVersion()
    {
        // NOTE: if the Z/IP specification changes from DTLS v1.0 to DTLS v1.2, return ProtocolVersion.DTLSv12 instead.
    	return ProtocolVersion.DTLSv10;
    }

    @Override
    public ProtocolVersion getMinimumVersion()
    {
        return ProtocolVersion.DTLSv10;
    }
    
    /*** AbstractTlsPeer overrides (TlsPeer interface) ***/
    
    @Override
    public void notifyAlertReceived(short alertLevel, short alertDescription)
    {
    	String alertLevelAsString = AlertLevel.getText(alertLevel);
    	String alertDescriptionAsString = AlertDescription.getName(alertDescription).toString();
    	
    	if (alertLevel == AlertLevel.warning && alertDescription == AlertDescription.close_notify) {
			/* Notify delegates that the socket has been closed by the remote computer.
			 * 
			 * The SecureDatagramSession will subscribe to this event (sole listener) to complete the
			 * socket closing locally, to make sure that all socket resources are cleaned up, and 
			 * to alert the session consumer that the connection is closed.
			 * 
			 * The session's consumer needs this information so that it can reconnect to the remote
			 * computer when necessary (instead of introducing communication delays by sending DTLS 
			 * packets to a remote computer that is not listening--and then having to retransmit
			 * after a response timeout occurs (or worse...not knowing that ACK-free data has not
			 * been sent to a listening target and therefore not attempting reconnection+retransmission).
			 * 
			 * Note that the notifyAlertReceived "close_notify" event is not received unless there is
			 * an outstanding receive(...) call which causes the underlying Java socket implementation
			 * to realize that the socket has been closed by the remote host.  Based on initial research,
			 * there is no reliable way to detect "close_notify" outside of an outstanding receive() and,
			 * therefore, there is no reasonable way to raise a "remoteNotifyClosed" event to the 
			 * ultimate consumer of the SecureDatagramSession class; we can only "assist" by providing
			 * a mechanism to throw an exception when the ultimate consumer attempts to receive(...) 
			 * (or has an outstanding receive(...) function at time of socket close). */
			if (this.socketRemoteCloseListener != null) {
				EventObject event = new EventObject(this);
				this.socketRemoteCloseListener.remoteSocketClosed(event);
			}
    	}
    	
    	super.notifyAlertReceived(alertLevel, alertDescription);
    }
    
    void addSocketRemoteCloseListener(RemoteSocketListener eventListener) throws java.util.TooManyListenersException {
    	if (this.socketRemoteCloseListener != null) {
    		throw new java.util.TooManyListenersException();
    	}
    	
    	this.socketRemoteCloseListener = eventListener;
    }
    
    void removeSocketRemoteCloseListener(RemoteSocketListener eventListener) {
    	if (this.socketRemoteCloseListener == eventListener) {
    		this.socketRemoteCloseListener = null;
    	}
    }
    
    @Override
    public void notifyHandshakeComplete() throws IOException
    {
        super.notifyHandshakeComplete();

        // NOTE: whenever the handshake process is completed, we either have (a) a new session or (b) a resumed session.
        //       in either case, we cache the new (resumable) session for our continued use.        
        TlsSession dtlsSession = context.getResumableSession();
        if (dtlsSession != null) {
            this.dtlsSession = dtlsSession;
        } else {
        	// NOTE: if the session is null, we retain our existing dtlsSession reference
        }
    }
    
}
