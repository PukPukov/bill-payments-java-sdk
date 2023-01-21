package com.qiwi.billpayments.sdk.client;

import org.apache.http.impl.client.HttpClients;

public final class BillPaymentClientFactory {

    private BillPaymentClientFactory() {}

    /**
     * Deprecated, use {@link com.qiwi.billpayments.sdk.client.BillPaymentClient#BillPaymentClient(String)}
     */
    @Deprecated
    public static BillPaymentClient createDefault(String secretKey) {
        return new BillPaymentClient(secretKey);
    }
    
}
