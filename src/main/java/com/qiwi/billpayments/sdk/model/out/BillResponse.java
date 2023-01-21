package com.qiwi.billpayments.sdk.model.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import com.qiwi.billpayments.sdk.model.in.CustomFields;
import com.qiwi.billpayments.sdk.model.in.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@With
public class BillResponse {

    private String siteId;
    private String billId;
    private MoneyAmount amount;
    private ResponseStatus status;
    private String comment;
    private Customer customer;
    private ZonedDateTime creationDateTime;
    private ZonedDateTime expirationDateTime;
    private String payUrl;
    private CustomFields customFields;
    private String recipientPhoneNumber;
    private Recipient recipient;
    
}
