package com.qiwi.billpayments.sdk.model.in;

import com.qiwi.billpayments.sdk.model.MoneyAmount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@ToString
@AllArgsConstructor
public class PaymentInfo {
    private final String publicKey;
    private final MoneyAmount amount;
    private final String billId;
    private final String successUrl;
    private final String themeCode;
    private final String paySourcesFilter;

    public PaymentInfo(
            String key, 
            MoneyAmount amount, 
            String billId, 
            String successUrl
    ) {
        this.publicKey = key;
        this.amount = amount;
        this.billId = billId;
        this.successUrl = successUrl;
        this.themeCode = null;
        this.paySourcesFilter = null;
    }
}
