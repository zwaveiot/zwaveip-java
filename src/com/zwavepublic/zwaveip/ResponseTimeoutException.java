package com.zwavepublic.zwaveip;

public class ResponseTimeoutException extends ZWaveIPException {
	public ResponseTimeoutException() {
	}
	public ResponseTimeoutException(String message) {
		super(message);
	}
}
