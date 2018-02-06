package com.zwavepublic.zwaveip;

public class AckTimeoutException extends ZWaveIPException {
	public AckTimeoutException() {
	}
	public AckTimeoutException(String message) {
		super(message);
	}
}
