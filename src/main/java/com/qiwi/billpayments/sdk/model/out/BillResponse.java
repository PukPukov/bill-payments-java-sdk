package com.qiwi.billpayments.sdk.model.out;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import com.qiwi.billpayments.sdk.model.in.CustomFields;
import com.qiwi.billpayments.sdk.model.in.Customer;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.time.ZonedDateTime;

@With
@Getter
@ToString
public class BillResponse {

    private final String siteId;
    private final String billId;
    private final MoneyAmount amount;
    private final ResponseStatus status;
    private final String comment;
    private final Customer customer;
    private final ZonedDateTime creationDateTime;
    private final ZonedDateTime expirationDateTime;
    private final String payUrl;
    private final CustomFields customFields;
    private final String recipientPhoneNumber;
    private final String customFieldsThemeCode;

    @JsonCreator
    public BillResponse(
            @JsonProperty("siteId") String siteId,
            @JsonProperty("billId") String billId,
            @JsonProperty("amount") MoneyAmount amount,
            @JsonProperty("status") ResponseStatus status,
            @JsonProperty("comment") String comment,
            @JsonProperty("customer") Customer customer,
            @JsonProperty("creationDateTime") ZonedDateTime creationDateTime,
            @JsonProperty("expirationDateTime") ZonedDateTime expirationDateTime,
            @JsonProperty("payUrl") String payUrl,
            @JsonProperty("customFields") CustomFields customFields,
            @JsonProperty("recipientPhoneNumber") String recipientPhoneNumber,
            @JsonProperty("customFields.themeCode") String customFieldsThemeCode
    ) {
        this.siteId = siteId;
        this.billId = billId;
        this.amount = amount;
        this.status = status;
        this.comment = comment;
        this.customer = customer;
        this.creationDateTime = creationDateTime;
        this.expirationDateTime = expirationDateTime;
        this.payUrl = payUrl;
        this.customFields = customFields;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.customFieldsThemeCode = customFieldsThemeCode;
    }

}
