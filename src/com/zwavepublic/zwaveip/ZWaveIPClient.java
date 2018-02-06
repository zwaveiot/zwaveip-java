package com.zwavepublic.zwaveip;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.bouncycastle.tls.BasicTlsPSKIdentity;
import org.bouncycastle.tls.TlsPSKIdentity;
import org.bouncycastle.util.Arrays;

import com.zwavepublic.zwaveip.command.Command;
import com.zwavepublic.zwaveip.command.CommandClass;
import com.zwavepublic.zwaveip.command.NetworkManagementProxyCommand;
import com.zwavepublic.zwaveip.command.ZipCommand;
import com.zwavepublic.zwaveip.command.ZipNdCommand;
import com.zwavepublic.zwaveip.net.SecureDatagramSession;

public class ZWaveIPClient {
	private SecureDatagramSession dtlsSession;
	private boolean isConnected;
	
	private InetAddress remoteAddress;
	private String pskIdentity;
	private byte[] pskPassword;
	
	private byte sequenceNumber;
	private Object sequenceNumberSyncObject;
	
	private Object receiveMessageSyncObject;
	
	private HashMap<Byte, AckRegistration> messagesWaitingForAck;
	private List<ResponseRegistration> pendingCommandResponses;
	
	
	/*** INIT AND DE-INIT FUNCTIONS ***/
	
	public ZWaveIPClient(InetAddress address, String pskIdentity, byte[] pskPassword) {
	    // store our connection parameters
		this.remoteAddress = address;
		this.pskIdentity = pskIdentity;
		this.pskPassword = pskPassword;
	    // create a variable to hold our DTLS session reference (once we send a message)
		this.dtlsSession = new SecureDatagramSession();
		// set isConnected to false (so we know to connect when the first message is sent)
		this.isConnected = false;
	    // randomize the initial sequenceNumber
		this.sequenceNumber = (byte)(Math.random() * 256);
	    // create a hash to hold a record of all outstanding messages which are waiting for an acknowledgment
	    this.messagesWaitingForAck = new HashMap<Byte, AckRegistration>();
	    // create an array to hold all outstanding commands which are waiting for responses
	    this.pendingCommandResponses = new ArrayList<ResponseRegistration>();
	    // initialize our synchronization (lock) objects
	    this.sequenceNumberSyncObject = new Object();
	    this.receiveMessageSyncObject = new Object();
	}
	
	public void close() throws IOException {
		if (isConnected == true) {
			this.dtlsSession.close();
		}
	}
		
	
	/*** MESSAGE TRANSMISSION FUNCTIONS ***/

	// convenience overload (for request/response with no responseMatchingId
	public byte[] sendMessageAndWaitForResponse(CommandClass commandClass, Command requestCommand, byte[] data, Command responseCommand) throws ZWaveIPException, IOException {
		return sendMessageAndWaitForResponse(commandClass, requestCommand, data, responseCommand, null);
	}
	
	// NOTE: this function sends a Z-Wave command, waits for an ACK, and then waits for a response to the command
	public byte[] sendMessageAndWaitForResponse(CommandClass commandClass, Command requestCommand, byte[] data, Command responseCommand, Byte responseMatchingId) throws ZWaveIPException, IOException {
		return internalSendMessageAndWaitForResponse(commandClass, requestCommand, data, responseCommand, responseMatchingId, true /* isWrappedInZipFrame */, false /* sendAsRawMessage */);		
	}
	
	public byte[] internalSendMessageAndWaitForResponse(CommandClass commandClass, Command requestCommand, byte[] data, Command responseCommand, Byte responseMatchingId, boolean isWrappedInZipFrame, boolean sendAsRawMessage) throws ZWaveIPException, IOException {
        // register our response callback (so that we are listening for the response)
    	int timeout = INTERNAL_ZWAVE_RESPONSE_TIMEOUT_MS;
    	ResponseRegistration responseRegistration = registerForResponse(commandClass, responseCommand, responseMatchingId, timeout, isWrappedInZipFrame);

		// send the message
    	if (sendAsRawMessage == true) {
    		// send the raw message (without waiting for an ACK)
    		sendRawMessage(commandClass, requestCommand, data);
    	} else {
    		// send the message and wait for ACK
    		sendMessage(commandClass, requestCommand, data);
    	}

        // update the response callback timer (so we don't count the DTLS connection or ACK time in our timeout)
        updateCommandResponseTimeout(responseRegistration, INTERNAL_ZWAVE_RESPONSE_TIMEOUT_MS);

        // listen for response/timeout
        int currentTimeoutInMillis = calculateRemainingMillisWithMinimumOfZero(responseRegistration.timeoutTimestamp);
        do {
	        // NOTE: receiveFromRemoteHost will throw an IOException on timeout
	        // NOTE: it would be smart to check for the TIMEOUT exception in particular...and rethrow OTHER exceptions
	        //       (while converting the timeout into an ACK or RESPONSE timeout exception for the consumer)
	        try {
	        	synchronized(receiveMessageSyncObject) {
	                /* NOTE: if we add a dedicated receive thread option in the future, wait on the
	                 * responseRegistration's "responseReceived" event flag here, until timeout, instead. */
	        		receiveFromRemoteHost(currentTimeoutInMillis);
	        	}
	        } catch (IOException ex) {
	        	// in case of timeout, throw a response timeout
	        	throw new com.zwavepublic.zwaveip.ResponseTimeoutException();
	        }
	        
	        // ZWaveIP received a new message, so check out our response registration's status; if our status has 
	        // not changed, then we must loop around again and continue to wait
	        
	        switch (responseRegistration.state) {
	        	case RECEIVED:
	        		// response was received
	        		return responseRegistration.getData();
	        }	 
	        
	        // update our current timeout in milliseconds (0 == timed out)
	        currentTimeoutInMillis = calculateRemainingMillisWithMinimumOfZero(responseRegistration.timeoutTimestamp);
        } while(currentTimeoutInMillis > 0);

        // if our message has timed out, throw a TimeoutException.
    	throw new com.zwavepublic.zwaveip.ResponseTimeoutException();
	}
	
	// NOTE: this function sends a Z-Wave command and waits for an ACK
	public void sendMessage(CommandClass commandClass, Command command, byte[] data) throws ZWaveIPException, IOException {
		// if the caller passed in a null data array, change our reference to a zero-element data set
		if (data == null) {
			data = new byte[0];
		}
		
	    int HEADER_SIZE = 10;
	    int offset = 0;

        Integer timeout = null;

        /* register our outgoing message (so that we are listening for an ACK) and obtain a sequence 
         * number.  If all sequence numbers are in use, we will get a result of null and will need to
         * wait until a sequence number becomes available. In the future, we may want to consider 
         * putting an upper bound on the amount of time we are willing to wait for a sequence number. */
        AckRegistration ackRegistration = null;
        while (ackRegistration == null) {
        	timeout = INTERNAL_ZWAVE_ACK_TIMEOUT_MS;
        	ackRegistration = registerMessageForAckAndReserveSequenceNumber(timeout);
        	
        	if (ackRegistration == null) {
        		// wait some milliseconds before attempting to request another sequence number
        		try {
        			Thread.sleep(INTERNAL_WAIT_MS_BETWEEN_SEQUENCE_NUMBER_ACQUISITION_ATTEMPTS);
        		} catch (InterruptedException ex) {
        			// ignore this exception, as we do not support thread interruption
        		}
        	}
        }
        
        // create z/ip packet
        byte[] packet = new byte[HEADER_SIZE + 2 + data.length];
        packet[offset] = CommandClass.ZIP.byteValue();
        offset += 1;
        packet[offset] = ZipCommand.COMMAND_ZIP_PACKET.byteValue();
        offset += 1;
        packet[offset] = ZIP_PACKET_FLAGS0.ACK_REQ.byteValue();
        offset += 1;
        packet[offset] = (byte)(ZIP_PACKET_FLAGS1.HDR_EXT_INCL.byteValue() | ZIP_PACKET_FLAGS1.ZW_CMD_INCL.byteValue() | ZIP_PACKET_FLAGS1.SECURE_ORIGIN.byteValue());
        offset += 1;
        packet[offset] = sequenceNumber;
        offset += 1;
        packet[offset] = 0x00; // bit 7: RES; bits 0-6: Source Endpoint
        offset += 1;
        packet[offset] = 0x00; // bit 7: Bit address; bits 0-6: Destination Endpoint
        offset += 1;
        packet[offset] = 0x03; // size of complete Z/IP header extension (including this byte)
        offset += 1;
        packet[offset] = ZIP_OPTION.MAINTENANCE_GET.byteValue();
        offset += 1;
        packet[offset] = 0x00; // length of option MAINTENANCE_GET (0 = no additional option fields for this option)
        offset += 1;
        packet[offset] = commandClass.byteValue();
        offset += 1;
        packet[offset] = command.byteValue();
        offset += 1;
        System.arraycopy(data, 0, packet, offset, data.length);
        offset += data.length;

        // save a copy of our message in the "waiting for ACK response" record in case we need to automatically resend it
        PacketData packetData = new PacketData(packet, 0, packet.length);
        ackRegistration.packetData = packetData;

        synchronized(receiveMessageSyncObject) {
	        // if our SecureDatagramSession is not yet connected, connect it now.
	        if (this.isConnected == false) {
	        	connectToZWaveIPServer();
	        		
	            // update our ack registration timeout (to remove any timespan introduced by DTLS session init)
	            updateAckRegistrationTimeout(ackRegistration, INTERNAL_ZWAVE_ACK_TIMEOUT_MS);
	        }
        }

        // send our message
        this.dtlsSession.send(packetData.msg, packetData.offset, packetData.length);
        
        // listen for ACK/NAK/timeout
        int currentTimeoutInMillis = calculateRemainingMillisWithMinimumOfZero(ackRegistration.timeoutTimestamp);
        do {
	        // NOTE: receiveFromRemoteHost will throw an IOException on timeout--so we do not need to exit this loop
	        // NOTE: it would be smart to check for the TIMEOUT exception in particular...and rethrow OTHER exceptions
	        //       (while converting the timeout into an ACK or RESPONSE timeout exception for the consumer)
	        try {
	        	synchronized(receiveMessageSyncObject) {
	                /* NOTE: if we add a dedicated receive thread option in the future, wait on the
	                 * ackRegistration's "ackReceived" (ACK/NAK) event flag here, until timeout, instead. */
	        		receiveFromRemoteHost(currentTimeoutInMillis);
	        	}
	        } catch (IOException ex) {
	        	// in case of timeout, throw an AckTimeoutException
	        	throw new com.zwavepublic.zwaveip.AckTimeoutException();
	        }
	        
	        // ZWaveIP received a new message, so check out our message's ACK status; if our status has 
	        // not changed, then we must loop around again and continue to wait
	        
	        switch (ackRegistration.state) {
	        	case ACK:
	        		// message was acknowledged
	        		return;
	        	case NAK:
	        		// message was NAK'd by the Z-Wave protocol
	        		throw new com.zwavepublic.zwaveip.NakException();
	        }	 
	        
	        // update our current timeout in milliseconds (0 == timed out)
	        currentTimeoutInMillis = calculateRemainingMillisWithMinimumOfZero(ackRegistration.timeoutTimestamp);
        } while(currentTimeoutInMillis > 0); 

        // if our message has timed out, throw an AckTimeoutException.
    	throw new com.zwavepublic.zwaveip.AckTimeoutException();
	}	
	
	
	/*** NODE ID TO IP ADDRESS TRANSLATION FUNCTIONS ***/
	
	public class IpAddressAndHomeId {
		public byte[] homeId;
		public InetAddress ipv6InetAddress;
		public InetAddress ipv4InetAddress;
		
		public IpAddressAndHomeId(byte[] homeId, InetAddress ipv6InetAddress, InetAddress ipv4InetAddress) {
			this.homeId = homeId.clone();
			this.ipv6InetAddress = ipv6InetAddress;
			this.ipv4InetAddress = ipv4InetAddress;
		}
	}
	//
	public IpAddressAndHomeId getIpAddressForNodeId(byte nodeId) throws ZWaveIPException, IOException {
		byte[] data = new byte[] { 0, nodeId };
		byte[] response = sendRawMessageAndWaitForResponse(CommandClass.ZIP_ND, ZipNdCommand.ZIP_INV_NODE_SOLICITATION, data, ZipNdCommand.ZIP_NODE_ADVERTISEMENT, nodeId);
	
		byte[] ipv4AddressAsByteArray = null;
		byte[] ipv6AddressAsByteArray = null;
		byte[] homeIdAsByteArray = null;
		
		if (data.length < 22) {
			throw new ZWaveIPException("Invalid response from Z-Wave device.");
		}
		
		int offset = 2;
		
		// ipv6 address
		ipv6AddressAsByteArray = new byte[IPV6_ADDRESS_BYTE_COUNT];
		System.arraycopy(response, offset, ipv6AddressAsByteArray, 0, IPV6_ADDRESS_BYTE_COUNT);
		offset += IPV6_ADDRESS_BYTE_COUNT;
		// homeID
		homeIdAsByteArray = new byte[HOME_ID_BYTE_COUNT];
		System.arraycopy(response, offset, homeIdAsByteArray, 0, HOME_ID_BYTE_COUNT);
		offset += HOME_ID_BYTE_COUNT;
		
        // check for an IPv4-mapped IPv6 address
		if (byteArrayContainsIpv6Address(ipv6AddressAsByteArray) == true) {
			ipv4AddressAsByteArray = new byte[IPV4_ADDRESS_BYTE_COUNT];
			System.arraycopy(ipv6AddressAsByteArray, 12, ipv4AddressAsByteArray, 0, IPV4_ADDRESS_BYTE_COUNT);
		}
		
		InetAddress ipv6InetAddress = null;
		// convert ipv6 address byte array to InetAddress
		ipv6InetAddress = InetAddress.getByAddress(ipv6AddressAsByteArray);
		
		InetAddress ipv4InetAddress = null;
		// convert ipv4 address byte array to InetAddress
		if (ipv4AddressAsByteArray != null) {
			ipv4InetAddress = InetAddress.getByAddress(ipv4AddressAsByteArray);
		}
		
		IpAddressAndHomeId result = new IpAddressAndHomeId(homeIdAsByteArray, ipv6InetAddress, ipv4InetAddress);
		return result;
	}

	boolean byteArrayContainsIpv6Address(byte[] ipv6AddressByteArray) {
	    if (ipv6AddressByteArray == null || ipv6AddressByteArray.length != 16) {
	        return false;
	    }

	    return ((ipv6AddressByteArray[0] == 0x00) &&
	      (ipv6AddressByteArray[1] == 0x00) &&
	      (ipv6AddressByteArray[2] == 0x00) &&
	      (ipv6AddressByteArray[3] == 0x00) &&
	      (ipv6AddressByteArray[4] == 0x00) &&
	      (ipv6AddressByteArray[5] == 0x00) &&
	      (ipv6AddressByteArray[6] == 0x00) &&
	      (ipv6AddressByteArray[7] == 0x00) &&
	      (ipv6AddressByteArray[8] == 0x00) &&
	      (ipv6AddressByteArray[9] == 0x00) &&
	      (ipv6AddressByteArray[10] == 0xFF) &&
	      (ipv6AddressByteArray[11] == 0xFF));
	}

	// NOTE: this function sends a raw Z-Wave command, does not wait for an ACK, but does wait for a (raw) response
	byte[] sendRawMessageAndWaitForResponse(CommandClass commandClass, Command requestCommand, byte[] data, Command responseCommand, Byte responseMatchingId) throws ZWaveIPException, IOException {
		return internalSendMessageAndWaitForResponse(commandClass, requestCommand, data, responseCommand, responseMatchingId, false /* isWrappedInZipFrame */, true /* sendAsRawMessage */);		
	}

	// NOTE: this function sends a raw Z-Wave command without wrapping it inside a Z/IP frame and without waiting for an acknowledgment
	void sendRawMessage(CommandClass commandClass, Command command, byte[] data) throws IOException {
		if (data == null) {
			// default
			data = new byte[0];
		}

	    int offset = 0;

	    // create z/ip packet
	    byte[] packet = new byte[2 + data.length];
	    packet[offset] = commandClass.byteValue();
	    offset += 1;
	    packet[offset] = command.byteValue();
	    offset += 1;
        System.arraycopy(data, 0, packet, offset, data.length);
        offset += data.length;

        PacketData packetData = new PacketData(packet, 0, packet.length);

        synchronized(receiveMessageSyncObject) {
	        // if our SecureDatagramSession is not yet connected, connect it now.
	        if (this.isConnected == false) {
	        	connectToZWaveIPServer();
	        }
        }
        
        // send our message
        this.dtlsSession.send(packetData.msg, packetData.offset, packetData.length);
	}
	
	private void connectToZWaveIPServer() throws IOException {
    	TlsPSKIdentity pskIdentity = new BasicTlsPSKIdentity(this.pskIdentity, this.pskPassword);
    	int port = 41230;

		// connect to the remote host using the specified psk identity parameters
		this.dtlsSession.connect(pskIdentity, this.remoteAddress, port);
		//
		this.isConnected = true;
		//
		/* for a small bit of extra security, dereference our cached pskIdentity and pskPassword (for GC)
		   [ideally we'd be able to write over pskIdentity with random data...but strings in Java are 
		   immutable; we do however write over the pskPassword here with all-zeros, a minimal effort.] */
		this.pskIdentity = null;
		for (int index = 0; index < this.pskPassword.length; index++) {
			this.pskPassword[index] = 0;
		}
		this.pskPassword = null;
	}

	
	/*** INCOMING MESSAGE RECEPTION FUNCTIONS ***/
	
	// NOTE: timeout is measured in milliseconds
	private void receiveFromRemoteHost(int timeout) throws IOException {
		/* NOTE: this function is designed to be called inside a synchronized(receiveMessageSyncObject)
		 * block; it is the programmer's responsibility to ensure that this function is not re-entered
		 * while it is still processing data.  We have chosen not to use a synchronization lock here for
		 * future-looking reasons. */
		
		/* NOTE: if we add a dedicated receive thread option in the future, we should:
		 * 1. trigger the dedicated receive thread option when add###Listener(...) is called, and 
		 *    deactivate it when remove###Listener is called.
		 * 2. give the dedicated receive thread exclusive domain over calling this function; the other
		 *    functions who receive data would then instead rely on flag events being set to unblock
		 *    before their timeouts expiration */

		/* NOTE: we may want to make this buffer a class-initialized buffer which gets reused in the
		 *       future; for easy reading of the code we have chosen not to do so at this time. */
		byte[] buffer = new byte[this.dtlsSession.getReceiveLimit()];
		int numberOfBytesReceived = this.dtlsSession.receive(buffer, 0, buffer.length, timeout);
		
		// fetch the received data (as our processReceivedPacket(...) function does not deal with offsets/counts
		byte[] newBuffer = new byte[numberOfBytesReceived];
		System.arraycopy(buffer,  0, newBuffer, 0, newBuffer.length);
		
		// process the received data
		processReceivedPacket(newBuffer);
	}
	
	private void processReceivedPacket(byte[] data) {
		if (data == null) {
			throw new NullPointerException();
		}

		int HEADER_MINIMUM_SIZE = 2;
		int ZIP_WRAPPED_HEADER_MINIMUM_SIZE = 7;
		if (data.length < HEADER_MINIMUM_SIZE) {
			// not enough data for any packet; abort.
			return;
		}
		
		boolean isWrappedInZipFrame = false;
		
	    // get the "initial" command class and command; in case of Z/IP-wrapped packets, these are the "header" (wrapping) command class and command
	    int offset = 0;
	    // command class
	    byte initialCommandClass = data[offset];
	    offset += 1;
	    // command
	    byte initialCommand = data[offset];
	    offset += 1;

	    if (initialCommandClass != CommandClass.ZIP.byteValue() || initialCommand != ZipCommand.COMMAND_ZIP_PACKET.byteValue())
	    {
	        // message is not enclosed in a Z/IP packet; handle this special case first
	        isWrappedInZipFrame = false;

	        if (initialCommandClass == CommandClass.ZIP_ND.byteValue() && initialCommand == ZipNdCommand.ZIP_NODE_ADVERTISEMENT.byteValue()) {
	            // allowed command
	        } else {
	            // if we do not recognize the command as an allowable "non-wrapped" incoming command/response, abort now
	            return;
	        }
	    }
	    else {
	        // otherwise, the packet is a Z/IP packet; make sure it is at least large enough for a minimal Z/IP packet
	        isWrappedInZipFrame = true;

	        if (data.length < ZIP_WRAPPED_HEADER_MINIMUM_SIZE)
	        {
	            // not enough data for minimal Z/IP packet; abort.
	            return;
	        }
	    }

	    // parse message
	    boolean ackResponse = false;
	    boolean nackResponse = false;
	    boolean nackWaiting = false;
	    boolean nackQueueFull = false;
	    boolean headerExtensionsIncluded = false;
	    Byte sequenceNumber = null;
	    int headerExtensionsLength;
	    Byte commandClass = null;
	    Byte command = null;
	    byte[] payload;
	    if (isWrappedInZipFrame) {
	        // AckRequest | AckResponse | NackResponse | NackFlags (Waiting, QueueFull, OptionError) | Reserved
	        ackResponse = ((data[offset] & ZIP_PACKET_FLAGS0.ACK_RES.byteValue()) != 0);
	        nackResponse = ((data[offset] & ZIP_PACKET_FLAGS0.NACK_RES.byteValue()) != 0);
	        nackWaiting = ((data[offset] & ZIP_PACKET_FLAGS0.WAIT_RES.byteValue()) != 0);
	        nackQueueFull = ((data[offset] & ZIP_PACKET_FLAGS0.NACK_QF.byteValue()) != 0);
	        offset += 1;
	        // HeaderExtIncluded | ZWaveCmdIncluded | MoreInformation | SecureOrigin | Reserved
	        headerExtensionsIncluded = ((data[offset] & ZIP_PACKET_FLAGS1.HDR_EXT_INCL.byteValue()) != 0);
	        offset += 1;
	        // SequenceNumber
	        sequenceNumber = data[offset];
	        offset += 1;
	        // Res | SourceEndPoint
	        offset += 1;
	        // BitAddress | DestinationEndpoint
	        offset += 1;
	        // Header Extensions (optional)
	        headerExtensionsLength = 0;
	        if (headerExtensionsIncluded) {
	            // first byte of header extensions: total length
	            headerExtensionsLength = data[offset];
	            // NOTE: we are currently ignoring extensions

	            offset += headerExtensionsLength;
	        }
	        //
	        if (data.length >= ZIP_WRAPPED_HEADER_MINIMUM_SIZE + headerExtensionsLength + 2) {
	            // command class
	            commandClass = data[offset];
	            offset += 1;
	            // command
	            command = data[offset];
	            offset += 1;
	        }
	    } else {
	        commandClass = initialCommandClass;
	        command = initialCommand;
	    }
	    //
	    // payload data
	    payload = new byte[data.length - offset];
	    System.arraycopy(data, offset, payload, 0, payload.length);
	    offset += payload.length;

	    if (isWrappedInZipFrame) {
	        // if this message is an ACK response, trigger any pending ACK 
	        if (ackResponse == true) {
	            AckRegistration ackRegistration = this.messagesWaitingForAck.get(sequenceNumber);
	            if (ackRegistration != null) {
	            	// if the ACK registration still exists, set its state to "acknowledged".
	            	ackRegistration.state = AckRegistrationState.ACK;
	            	// and remove the registration from the queue (as this is a final state)
	            	this.messagesWaitingForAck.remove(sequenceNumber);
	            }
	        }
	        else if (nackResponse) {
	            if (nackQueueFull) {
	                // queue full: retry sending message in INTERNAL_ZWAVE_NACK_QUEUE_FULL_RETRY_MS seconds
	            	int nackRetryTimeoutInMilliseconds = INTERNAL_ZWAVE_NACK_QUEUE_FULL_RETRY_MS + INTERNAL_ZWAVE_RESPONSE_TIMEOUT_MS;

		            AckRegistration ackRegistration = this.messagesWaitingForAck.get(sequenceNumber);

	            	Timer nackRetryTimer = new Timer();
	            	class NackRetryTimerTask extends TimerTask {
	            		SecureDatagramSession dtlsSession;
	            		AckRegistration ackRegistration;
	            		
	            		NackRetryTimerTask(SecureDatagramSession dtlsSession, AckRegistration ackRegistration) {
	            			this.dtlsSession = dtlsSession;
	            			this.ackRegistration = ackRegistration;
	            		}
	            		
	            		public void run() {
	            			if (this.ackRegistration != null && this.ackRegistration.state == AckRegistrationState.WAITING) {
		            	        // re-send our message
		            	        try {
									this.dtlsSession.send(ackRegistration.packetData.msg, ackRegistration.packetData.offset, ackRegistration.packetData.length);
								} catch (IOException e) {
									// if we fail to send the request, then just let the request timeout (gracefully degrade)
								}
	            			}
	            		}
	            	}
	            	
	            	// update our ackRegistration's timeout
	            	updateAckRegistrationTimeout(ackRegistration, nackRetryTimeoutInMilliseconds);
	            	// schedule the "nack queue full" retry timer
	            	nackRetryTimer.schedule(new NackRetryTimerTask(this.dtlsSession, ackRegistration), nackRetryTimeoutInMilliseconds);
	            } else if (nackWaiting) {
		            AckRegistration ackRegistration = this.messagesWaitingForAck.get(sequenceNumber);
		            if (ackRegistration != null) {
		                // add significant additional "wait time" to the ACK timeout timer 
		            	updateAckRegistrationTimeout(ackRegistration, INTERNAL_ZWAVE_NACK_WAITING_EXTENSION_MS);
		            }
	            } else {
	                // message was rejected
		            AckRegistration ackRegistration = this.messagesWaitingForAck.get(sequenceNumber);
		            if (ackRegistration != null) {
		            	// if the ACK registration still exists, set its state to "acknowledged".
		            	ackRegistration.state = AckRegistrationState.NAK;
		            	// and remove the registration from the queue (as this is a final state)
		            	this.messagesWaitingForAck.remove(sequenceNumber);
		            }
	            } 
	        }
	    }

	    if (commandClass != null && command != null) {
	        // for data packets: treat this message as a response and check it against the "pending command callbacks" list
	        for (int iResponse = 0; iResponse < this.pendingCommandResponses.size(); iResponse++)
	        {
	        	ResponseRegistration responseRegistration = this.pendingCommandResponses.get(iResponse);
	        	if (responseRegistration.commandClass.byteValue() == commandClass && responseRegistration.command.byteValue() == command && responseRegistration.isWrappedInZipFrame == isWrappedInZipFrame) {
	                // command class and command matches; check timeout
	                if (checkTimeoutHasOccured(responseRegistration.timeoutTimestamp))
	                {
	                    // command has timed out; remove this entry (and decrement iResponse so we check the item at this index again)
	                	this.pendingCommandResponses.remove(iResponse);
	                	iResponse--;
	                    continue;
	                }

	                // command class and command match and timeout has not expired; check match identifier if one exists
	                if (commandClass == CommandClass.NETWORK_MANAGEMENT_PROXY.byteValue() && command == NetworkManagementProxyCommand.NODE_LIST_REPORT.byteValue()) {
	                    if (payload.length < 1 || payload[0] != responseRegistration.matchIdentifier) {
	                        // NOTE: matchIdentifier is the sequenceNumber
	                        // match identifier does not match; skip this entry
	                        continue;
	                    }
	                }
	                else if(commandClass == CommandClass.ZIP_ND.byteValue() && command == ZipNdCommand.ZIP_NODE_ADVERTISEMENT.byteValue()) {
	                    if (payload.length < 2 || payload[1] != responseRegistration.matchIdentifier) {
	                        // NOTE: matchIdentifier is the nodeId
	                        // match identifier does not match; skip this entry
	                        continue;
	                    }
	                }
	                // else...

	                // if we reach here, the response matches; remove the response registration entry
	                // save the payload in the response registration object
	                responseRegistration.setData(payload);
	                // set the ResponseRegistration state to "RECEIVED"
	                responseRegistration.state = ResponseRegistrationState.RECEIVED;
	                // remove the callback from the pending callbacks list
	                this.pendingCommandResponses.remove(iResponse);
	                /* NOTE: if we add a dedicated receive thread option in the future, trigger the
	                 * "responseReceived" flag event here so that sendMessage(...) unblocks. */
	                break;
	            }
	        }
	    }

	    // NOTE: if there was no callback registered for this command, simply discard this packet.
	}
	
	// NOTE: due to potential multi-processor and out-of-order-execution glitches in various Java
	//       implementations, we calculate elapsed time in special functions which can take additional
	//       factors into account such as ensuring that the elapsed time is >= 0.
	// NOTE: we use system.Time() to measure time because it is the Java timing primitive which is not
	//       tied to "date/time"--which means that adjustments to the system clock will not affect its
	//       readings.
	private int calculateRemainingMillisWithMinimumOfZero(long timeout) {
		return (int)(Math.max(timeout - System.nanoTime(), 0) / NANOSECONDS_PER_MILLISECOND);
	}
	
	
	/*** OUTGOING MESSAGE HELPER FUNCTIONS ***/

	private void incrementSequenceNumber() {
	    /* NOTE: for details on sequence numbers, see section 3.58.1 (Z/IP Packet Command) of the Z-Wave command class document 
	     *       (the sequence number can be shared globally, is 8-bit, and we initialized it to a random value) */
	    this.sequenceNumber = (byte)((this.sequenceNumber + 1) % 256);
	}
	
	private AckRegistration registerMessageForAckAndReserveSequenceNumber(int timeoutInMilliseconds) {
		long timeoutTimestamp = createTimestampByOffset(timeoutInMilliseconds);

		// this operation is sync'd for thread safety (as it relies on control over the sequence number)
		synchronized(this.sequenceNumberSyncObject) {
			// try to generate a unique sequence number up to 256 times
		    for (int i = 0; i < 256; i++)
		    {
		        this.incrementSequenceNumber();
	
		        AckRegistration ackRegistration = this.messagesWaitingForAck.get(this.sequenceNumber);
		        if (ackRegistration != null) {
		            if (checkTimeoutHasOccured(ackRegistration.timeoutTimestamp)) {
		                /* this function is responsible for clearing out expired AckRegistration
		            	 * records (whereas the "receive message" function is responsible for clearing
		            	 * them out once an ACK/NAK is received */
		            	this.messagesWaitingForAck.remove(this.sequenceNumber);
		            } else {
		                // this sequence number is still active; try another slot.
		                continue;
		            }
		        }
	
		        ackRegistration = new AckRegistration(this.sequenceNumber, timeoutTimestamp);
		        this.messagesWaitingForAck.put(this.sequenceNumber, ackRegistration);
		        return ackRegistration;
		    }
		}

	    // if no message slots (sequence numbers) are available, return null.
	    return null;
	}
	
	void updateAckRegistrationTimeout(AckRegistration ackRegistration, int timeoutInMilliseconds) {
		ackRegistration.timeoutTimestamp = createTimestampByOffset(timeoutInMilliseconds);
	}

	
	/*** INCOMING RESPONSE HELPER FUNCTIONS ***/

	ResponseRegistration registerForResponse(CommandClass commandClass, Command responseCommand, Byte matchIdentifer, int timeoutInMilliseconds, boolean isWrappedInZipFrame) {
		long timeoutTimestamp = createTimestampByOffset(timeoutInMilliseconds);

		ResponseRegistration responseRegistration = new ResponseRegistration(commandClass, responseCommand, matchIdentifer, timeoutTimestamp, isWrappedInZipFrame);
		this.pendingCommandResponses.add(responseRegistration);
		
	    return responseRegistration;
	}

	void updateCommandResponseTimeout(ResponseRegistration responseRegistration, int timeoutInMilliseconds) {
		responseRegistration.timeoutTimestamp = createTimestampByOffset(timeoutInMilliseconds);
	}
	
	
	/*** SHARED TIMEKEEPING FUNCTIONS ***/
	
	boolean checkTimeoutHasOccured(long timestamp) {
		long currentTime = System.nanoTime();
		if (timestamp < currentTime) {
			return true;
		} else {
			return false;
		}
	}

	long addTime(long baseTime, int millisecondsToAdd) {
	    return baseTime + (millisecondsToAdd * NANOSECONDS_PER_MILLISECOND);
	}

	
	long createTimestampByOffset(int millisecondsToAdd) {
	    long currentTime = System.nanoTime();
	    return addTime(currentTime, millisecondsToAdd);
	}
	

	/*** CONSTANTS AND ENUMERATIONS ***/

	/* timekeeping constants */
	private final int NANOSECONDS_PER_MILLISECOND = 1000000;
	
	/* time to wait between attempts to acquire a sequence number */
	private final int INTERNAL_WAIT_MS_BETWEEN_SEQUENCE_NUMBER_ACQUISITION_ATTEMPTS = 100;
	
	/* ZIP constants for internal use */
	private final int INTERNAL_ZWAVE_ACK_TIMEOUT_MS = 300;
	private final int INTERNAL_ZWAVE_RESPONSE_TIMEOUT_MS = 2000;
	private final int INTERNAL_ZWAVE_NACK_QUEUE_FULL_RETRY_MS = 10000;
	private final int INTERNAL_ZWAVE_NACK_WAITING_EXTENSION_MS = 90000;
	
	/* misc constants */
	private final int IPV4_ADDRESS_BYTE_COUNT = 4;
	private final int IPV6_ADDRESS_BYTE_COUNT = 16;
	private final int HOME_ID_BYTE_COUNT = 4;
	
	/* ZIP enumerations for internal use */
	private enum ZIP_PACKET_FLAGS0 {
	    ACK_REQ((byte)0x80),
	    ACK_RES((byte)0x40),
	    NACK_RES((byte)0x20),
	    WAIT_RES((byte)0x10),
	    NACK_QF((byte)0x08);
	    
	    private byte _byteValue;

	    private ZIP_PACKET_FLAGS0(byte value) {
	        this._byteValue = value;
	    }

	    public byte byteValue() {
	        return this._byteValue;
	    }
	}

	private enum ZIP_PACKET_FLAGS1 {
	    HDR_EXT_INCL((byte)0x80),
	    ZW_CMD_INCL((byte)0x40),
	    MORE_INFORMATION((byte)0x20),
	    SECURE_ORIGIN((byte)0x10);
		
	    private byte _byteValue;

	    private ZIP_PACKET_FLAGS1(byte value) {
	        this._byteValue = value;
	    }

	    public byte byteValue() {
	        return this._byteValue;
	    }
	}

	private enum ZIP_OPTION {
	    EXPECTED_DELAY((byte)1),
	    MAINTENANCE_GET((byte)2),
	    MAINTENANCE_REPORT((byte)3);
	
	    private byte _byteValue;
	
	    private ZIP_OPTION(byte value) {
	        this._byteValue = value;
	    }
	
	    public byte byteValue() {
	        return this._byteValue;
	    }
	}

	/* AckRegistration */
	private enum AckRegistrationState {
		WAITING,
		ACK,
		NAK;
	}
	//
	private class AckRegistration {
		byte sequenceNumber;
		long timeoutTimestamp;
		PacketData packetData;
		AckRegistrationState state;
        /* NOTE: if we add a dedicated receive thread option in the future, add an "ackReceived"
         * flag here (which will trigger sendMessage(...) thread to unblock). */
		
		AckRegistration(byte sequenceNumber, long timeoutTimestamp) {
			this.sequenceNumber = sequenceNumber;
			this.timeoutTimestamp = timeoutTimestamp;
			//
			this.packetData = null;
			this.state = AckRegistrationState.WAITING;
		}
	}

	/* ResponseRegistration */
	private enum ResponseRegistrationState {
		WAITING,
		RECEIVED;
	}
	private class ResponseRegistration {
		CommandClass commandClass;
		Command command;
		Byte matchIdentifier;
		long timeoutTimestamp;
		boolean isWrappedInZipFrame;	
		private byte[] data;
		ResponseRegistrationState state;
        /* NOTE: if we add a dedicated receive thread option in the future, add a "responseReceived"
         * flag here (which will trigger sendMessageAndWaitForResponse(...) thread to unblock). */
		
		ResponseRegistration(CommandClass commandClass, Command command, Byte matchIdentifier, long timeoutTimestamp, boolean isWrappedInZipFrame) {
			this.commandClass = commandClass;
			this.command = command;
			this.matchIdentifier = matchIdentifier;
			this.timeoutTimestamp = timeoutTimestamp;
			this.isWrappedInZipFrame = isWrappedInZipFrame; // true for most responses (wrapped in Z/IP); false for special responses (like Z/IP Node Advertisement)
			this.state = ResponseRegistrationState.WAITING;
		}
		
		public void setData(byte[] data) {
			this.data = data;
		}
		
		public byte[] getData() {
			return this.data.clone();
		}
	}

	private class PacketData {
		public byte[] msg;
		public int offset;
		public int length;
		
		public PacketData(byte[] msg, int offset, int length) {
			this.msg = msg;
			this.offset = offset;
			this.length = length;
		}
	}
	
}
