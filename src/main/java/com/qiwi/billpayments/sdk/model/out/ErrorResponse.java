package com.qiwi.billpayments.sdk.model.out;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.time.ZonedDateTime;

@With
@Getter
@ToString
public class ErrorResponse {

    private final String serviceName;
    private final String errorCode;
    private final String description;
    private final String userMessage;
    private final ZonedDateTime dateTime;
    private final String traceId;

    @JsonCreator
    public ErrorResponse(
            @JsonProperty("serviceName") String serviceName,
            @JsonProperty("errorCode") String errorCode,
            @JsonProperty("description") String description,
            @JsonProperty("userMessage") String userMessage,
            @JsonProperty("dateTime") ZonedDateTime dateTime,
            @JsonProperty("traceId") String traceId
    ) {
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.description = description;
        this.userMessage = userMessage;
        this.dateTime = dateTime;
        this.traceId = traceId;
    }

}
