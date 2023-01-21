package com.qiwi.billpayments.sdk.client;

import com.qiwi.billpayments.sdk.model.out.BillResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.http.client.utils.URIBuilder;

import java.util.function.Supplier;

@AllArgsConstructor
public class SuccessURLAppender implements Supplier<BillResponse> {
    
    private final BillResponse response;
    private final String successURL;

    @Override
    @SneakyThrows
    public BillResponse get() {
        String updatedUrl = new URIBuilder(response.getPayUrl())
                .addParameter("successUrl", successURL)
                .build()
                .toString();
        return response.withPayUrl(updatedUrl);
    }
}
