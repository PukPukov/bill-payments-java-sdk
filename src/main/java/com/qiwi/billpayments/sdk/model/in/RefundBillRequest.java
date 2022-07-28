package com.qiwi.billpayments.sdk.model.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@ToString
public class RefundBillRequest {

    private final MoneyAmount amount;

    @JsonCreator
    public RefundBillRequest(@JsonProperty("amount") MoneyAmount amount) {
        this.amount = amount;
    }
}
