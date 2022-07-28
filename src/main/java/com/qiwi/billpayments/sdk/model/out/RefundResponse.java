package com.qiwi.billpayments.sdk.model.out;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.time.ZonedDateTime;

@With
@Getter
@ToString
public class RefundResponse {
    private final MoneyAmount amount;
    private final ZonedDateTime dateTime;
    private final String refundId;
    private final RefundStatus status;

    @JsonCreator
    public RefundResponse(
            @JsonProperty("amount") MoneyAmount amount,
            @JsonProperty("dateTime") ZonedDateTime dateTime,
            @JsonProperty("refundId") String refundId,
            @JsonProperty("status") RefundStatus status
    ) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.refundId = refundId;
        this.status = status;
    }
}
