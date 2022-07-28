package com.qiwi.billpayments.sdk.model.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@ToString
public class Customer {
    private final String email;
    private final String account;
    private final String phone;

    @JsonCreator
    public Customer(
            @JsonProperty("email") String email,
            @JsonProperty("account") String account,
            @JsonProperty("phone") String phone
    ) {
        this.email = email;
        this.account = account;
        this.phone = phone;
    }
}
