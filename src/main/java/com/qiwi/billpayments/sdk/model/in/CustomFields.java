package com.qiwi.billpayments.sdk.model.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@With
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CustomFields {
    private final String apiClient;
    private final String apiClientVersion;
    private final String checkoutReferer;
    private final String themeCode;
    private final String paySourcesFilter;

    @JsonCreator
    public CustomFields(
            @JsonProperty("apiClient") String apiClient,
            @JsonProperty("apiClientVersion") String apiClientVersion,
            @JsonProperty("CHECKOUT_REFERER") String checkoutReferer,
            @JsonProperty("themeCode") String themeCode,
            @JsonProperty("paySourcesFilter") String paySourcesFilter
    ) {
        this.apiClient = apiClient;
        this.apiClientVersion = apiClientVersion;
        this.checkoutReferer = checkoutReferer;
        this.themeCode = themeCode;
        this.paySourcesFilter = paySourcesFilter;
    }

    public CustomFields(String client, String version, String checkoutReferer) {
        this.apiClient = client;
        this.apiClientVersion = version;
        this.checkoutReferer = checkoutReferer;
        this.themeCode = null;
        this.paySourcesFilter = null;
    }
}
