package com.qiwi.billpayments.sdk.exception;

import com.qiwi.billpayments.sdk.model.out.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.impl.EnglishReasonPhraseCatalog;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.Locale;

@Getter
public class ServerRespondedWithErrorException extends ResponseException {

    @Nullable
    private final ErrorResponse errorResponse;
    private final int errorCode;
    
    public ServerRespondedWithErrorException(@Nullable ErrorResponse errorResponse, int errorCode) {
        super(
                "\n"+
                "--- QIWI BILLPAYMENTS SDK EXCEPTION ---\n"+
                "QIWI Server responded with error!\n" + 
                "Error code: "+ errorCode + " ("+ EnglishReasonPhraseCatalog.INSTANCE.getReason(errorCode, Locale.ENGLISH) + ")\n" +
                "Error body: "+ errorResponse+ "\n"+
                "--- --- --- --- --- --- --- --- --- ---"
        );
        this.errorResponse = errorResponse;
        this.errorCode = errorCode;
    }

    public ErrorResponse getResponse() {
        return errorResponse;
    }

    public int getHttpStatus() {
        return errorCode;
    }
}
