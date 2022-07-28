package com.qiwi.billpayments.sdk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@With
@AllArgsConstructor
@ToString
public class Bill {

    private final String siteId;
    private final String billId;
    private final MoneyAmount amount;
    private final BillStatus status;

}
