package com.qiwi.billpayments.sdk.exception;

import com.qiwi.billpayments.sdk.model.ResponseData;
import lombok.Getter;

@Getter
public class BadResponseException extends RuntimeException {

    private final int httpStatus;

    public BadResponseException(ResponseData responseData) {
        super(responseData.toString());
        this.httpStatus = responseData.getHttpStatus();
    }

    public BadResponseException(int httpStatus) {
        super("empty body, HTTP status " + httpStatus);
        this.httpStatus = httpStatus;
    }
}
