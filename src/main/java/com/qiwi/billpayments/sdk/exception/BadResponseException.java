package com.qiwi.billpayments.sdk.exception;

import lombok.Getter;
import org.apache.http.impl.EnglishReasonPhraseCatalog;

import java.util.Locale;

@Getter
public class BadResponseException extends ResponseException {

    private final String responseBody;
    private final int responseCode;
    private final Class<?> targetClass;
    private final String originalMessage;
    
    public BadResponseException(String responseBody, int responseCode, Class<?> targetClass, String message) {
        super(
                "\n"+ 
                "--- QIWI BILLPAYMENTS SDK EXCEPTION ---\n"+
                "Server responded with strange data, that cannot be mapped to "+targetClass.getName()+".\n"+
                "Maybe QIWI again broke backward compatibility?\n" +
                "Response code: "+ responseCode + " (" + EnglishReasonPhraseCatalog.INSTANCE.getReason(responseCode, Locale.ENGLISH) + ")\n"+ 
                "Additional information: "+ message + "\n"+
                "--- --- --- --- --- --- --- --- --- ---"
        );
        this.responseBody = responseBody;
        this.responseCode = responseCode;
        this.targetClass = targetClass;
        this.originalMessage = message;
    }

    public int getHttpStatus() {
        return responseCode;
    }
}
