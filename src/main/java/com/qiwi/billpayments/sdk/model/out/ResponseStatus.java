package com.qiwi.billpayments.sdk.model.out;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qiwi.billpayments.sdk.model.BillStatus;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.time.ZonedDateTime;

@With
@Getter
@ToString
public class ResponseStatus {
    private final BillStatus value;
    private final ZonedDateTime changedDateTime;

    @JsonCreator
    public ResponseStatus(
            @JsonProperty("value") BillStatus value,
            @JsonProperty("changedDateTime") ZonedDateTime changedDateTime
    ) {
        this.value = value;
        this.changedDateTime = changedDateTime;
    }
}
