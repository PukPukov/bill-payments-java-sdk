package com.qiwi.billpayments.sdk.model.in;

import com.qiwi.billpayments.sdk.model.MoneyAmount;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.time.ZonedDateTime;

@With
@Getter
@ToString
public class CreateBillInfo {
    private final String billId;
    private final MoneyAmount amount;
    private final String comment;
    private final ZonedDateTime expirationDateTime;
    private final Customer customer;
    private final String successUrl;

    public CreateBillInfo(
            String billId,
            MoneyAmount amount,
            String comment,
            ZonedDateTime expirationDateTime,
            Customer customer,
            String successUrl
    ) {
        this.billId = billId;
        this.amount = amount;
        this.comment = comment;
        this.expirationDateTime = expirationDateTime;
        this.customer = customer;
        this.successUrl = successUrl;
    }
}
