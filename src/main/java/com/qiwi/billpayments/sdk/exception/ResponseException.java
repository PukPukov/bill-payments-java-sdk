package com.qiwi.billpayments.sdk.exception;

public class ResponseException extends RuntimeException {
    
    public ResponseException() {
        super();
    }
    
    public ResponseException(String message) {
        super(message);
    }
}
