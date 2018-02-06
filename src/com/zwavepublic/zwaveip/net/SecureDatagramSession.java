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
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.EventObject;
import java.util.TooManyListenersException;

import org.bouncycastle.tls.DTLSClientProtocol;
import org.bouncycastle.tls.DTLSTransport;
import org.bouncycastle.tls.DatagramTransport;
import org.bouncycastle.tls.TlsPSKIdentity;
import org.bouncycastle.tls.UDPTransport;
import org.bouncycastle.tls.crypto.TlsCrypto;
import org.bouncycastle.tls.crypto.impl.bc.BcTlsCrypto;

public class SecureDatagramSession implements PSKDtlsClient.RemoteSocketListener {
	private static final SecureRandom secureRandom;
	private static TlsCrypto crypto;

	static {
		secureRandom = new SecureRandom();
		crypto = new BcTlsCrypto(secureRandom);
	}

	private InetAddress remoteInetAddress;
	private int remotePort;

	private DatagramSocket socket;
	private PSKDtlsClient dtlsClient;
	private DTLSTransport dtlsTransport;
	
	private Object connectSyncObject;

	public SecureDatagramSession() {
		this.remoteInetAddress = null;
		this.remotePort = -1;
		//
		this.socket = null;
		this.dtlsClient = null;
		this.dtlsTransport = null;
		//
		this.connectSyncObject = new Object();
	}
	
	InetAddress getRemoteInetAddress() {
		return this.remoteInetAddress;
	}
	
	int getRemotePort() {
		return this.remotePort;
	}
	
	public void connect(TlsPSKIdentity pskIdentity, InetAddress address, int port) throws IOException {
		// NOTE: as an extra layer of protection, we synchronize access to connect/reconnect/close
		synchronized(this.connectSyncObject) {
			// create a socket instance, connect via UDP, and wrap this all up in a UdpTransport.
			EstablishDatagramTransportResult establishDatagramTransportResult = establishDatagramTransport(address, port);
			DatagramSocket datagramSocket = establishDatagramTransportResult.datagramSocket;
			DatagramTransport datagramTransport = establishDatagramTransportResult.datagramTransport;
			
			// instantiate a PSKDTLSClient object using our static crypto instance and the provided PSK identity
			PSKDtlsClient dtlsClient = new PSKDtlsClient(crypto, pskIdentity);
			// subscribe to its socketRemoteClosed event (which tells us when the remote host closes a socket)
			try {
				dtlsClient.addSocketRemoteCloseListener(this);
			} catch(TooManyListenersException ex) {
				// no other objects should ever attempt to subscribe to this notification, so receiving
				// this event represents a programming error (i.e. unpredictable outcome)
				throw new RuntimeException(ex);
			}
			
			// establish our DTLS transport (using our new DTLS client and underlying datagram transport)
			DTLSTransport dtlsTransport = establishDtlsTransport(dtlsClient, datagramTransport);
			
			// now that we have successfully connected, store a reference to our client and transport.
			this.socket = datagramSocket;
			this.dtlsClient = dtlsClient;
			this.dtlsTransport = dtlsTransport;
			
			// and store our remote address/port; our PSK identity is already saved in the DTLSClient/Transport
			this.remoteInetAddress = address;
			this.remotePort = port;
		}
	}
	
	public void reconnect() throws IOException {
		synchronized(this.connectSyncObject) {
			// sanity check: make sure the existing socket, if any, is closed
			this.socket.close();
			
			// create a socket instance, connect via UDP, and wrap this all up in a UdpTransport.
			EstablishDatagramTransportResult establishDatagramTransportResult = establishDatagramTransport(this.remoteInetAddress, this.remotePort);
			DatagramSocket datagramSocket = establishDatagramTransportResult.datagramSocket;
			DatagramTransport datagramTransport = establishDatagramTransportResult.datagramTransport;
			
			// re-establish our DTLS transport (using our existing DTLS client and new underlying datagram transport)
			DTLSTransport dtlsTransport = establishDtlsTransport(this.dtlsClient, datagramTransport);
			
			// store an reference to our new socket and transport instances.
			this.socket = datagramSocket;
			this.dtlsTransport = dtlsTransport;
		}
	}

	public void close() throws IOException {
		synchronized(this.connectSyncObject) {
			// close the DTLS transport
			this.dtlsTransport.close();
			// close the socket (so that any outstanding receive(...) calls receive a SocketException due to the socket being closed)
			this.socket.close();
			
			/* NOTE: we do not unsubscribe from the "socketRemoteNotifyClosed" event because it is tied
			 *       to our DTLS session -- and the DTLS session is reused until we are disposed of. */ 
		}
	}
	
	@Override
	// implements: PSKDtlsClient.RemoteSocketListener.remoteSocketClosed()
	public void remoteSocketClosed(EventObject source) {
		// this event is called when the underlying datagram socket is closed by the remote host
		
		/* close our end of the connection; this will ensure than any outstanding receive(...) calls
		 * are thrown a SocketException (so they are aware that the remote host has disconnected and,
		 * by definition, terminated the session). */
		try {
			this.close();
		} catch(IOException ex) {
			// ignore any IOExceptions during mutual close procedure
		}
	}

	// getReceiveLimit() returns the maximum payload size for received datagrams (i.e. MTU - headers)
	public int getReceiveLimit() throws IOException {
		return this.dtlsTransport.getReceiveLimit();
	}
	
	// getSendLimit() returns the maximum payload size for sent datagrams (i.e. MTU - headers)
	public int getSendLimit() throws IOException {
		return this.dtlsTransport.getSendLimit();
	}
	
    public void send(byte[] buffer) throws IOException
    {
    	send(buffer, 0, buffer.length);
    }

    public void send(byte[] buffer, int offset, int length) throws IOException
    {
    	this.dtlsTransport.send(buffer, offset, length);
    }
    
    public int receive(byte[] buffer, int offset, int length, int waitMillis) throws IOException {
    	return this.dtlsTransport.receive(buffer, offset, length, waitMillis);
    }

    private class EstablishDatagramTransportResult {
    	DatagramSocket datagramSocket;
    	DatagramTransport datagramTransport;
    	
    	EstablishDatagramTransportResult(DatagramSocket datagramSocket, DatagramTransport datagramTransport) {
    		this.datagramSocket = datagramSocket;
    		this.datagramTransport = datagramTransport;
    	}
    }
	private EstablishDatagramTransportResult establishDatagramTransport(InetAddress address, int port) throws IOException {
		// create a datagram socket and connect to the target address+port
		DatagramSocket datagramSocket = new DatagramSocket();
		datagramSocket.connect(address, port);
		
		// wrap our socket in a BouncyCastle UDPTransport instance
		int mtu = 1500; // default Ethernet MTU: 1500 bytes (use a smaller value if desired)
		DatagramTransport datagramTransport;
		datagramTransport = new UDPTransport(datagramSocket, mtu);

//		// OPTIONAL: wrap our datagramTransport in a logging transport layer
//		datagramTransport = new com.zwavepublic.zwaveip.net.debug.LoggingDatagramTransport(datagramTransport, System.out);

		return new EstablishDatagramTransportResult(datagramSocket, datagramTransport);
	}
	
	private DTLSTransport establishDtlsTransport(PSKDtlsClient dtlsClient, DatagramTransport datagramTransport) throws IOException {
		// create an instance of BouncyCastle's DTLSClientProtocol; use it to connect via DTLS (using 
		// our established DatagramTransport) and return the resulting DTLSTransport instance.
		DTLSClientProtocol protocol = new DTLSClientProtocol();
		DTLSTransport dtlsTransport;
		dtlsTransport = protocol.connect(dtlsClient, datagramTransport);
		
		return dtlsTransport;
	}
		
}
