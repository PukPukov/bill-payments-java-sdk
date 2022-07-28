package com.qiwi.billpayments.sdk.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Getter
@With
@ToString
@EqualsAndHashCode
public class MoneyAmount {
    private final BigDecimal value;
    private final Currency currency;

    @JsonCreator
    public MoneyAmount(
            @JsonProperty("value") BigDecimal value,
            @JsonProperty("currency") Currency currency
    ) {
        this.value = value;
        this.currency = currency;
    }

    public String formatValue() {
        return value.setScale(2, RoundingMode.HALF_DOWN).toString();
    }
}
