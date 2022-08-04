package com.qiwi.billpayments.sdk.model.in;

import com.qiwi.billpayments.sdk.model.MoneyAmount;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@ToString
public class PaymentInfo {
    private final String publicKey;
    private final MoneyAmount amount;
    private final String billId;
    private final String successUrl;
    private final String themeCode;

    public PaymentInfo(
            String publicKey,
            MoneyAmount amount,
            String billId,
            String successUrl,
            String themeCode
    ) {
        this.publicKey = publicKey;
        this.amount = amount;
        this.billId = billId;
        this.successUrl = successUrl;
        this.themeCode = themeCode;
    }
}
