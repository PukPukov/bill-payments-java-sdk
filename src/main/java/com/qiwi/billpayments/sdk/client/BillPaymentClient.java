package com.qiwi.billpayments.sdk.client;

import com.qiwi.billpayments.sdk.PomInfo;
import com.qiwi.billpayments.sdk.exception.UrlEncodingException;
import com.qiwi.billpayments.sdk.model.MoneyAmount;
import com.qiwi.billpayments.sdk.model.in.CreateBillInfo;
import com.qiwi.billpayments.sdk.model.in.CreateBillRequest;
import com.qiwi.billpayments.sdk.model.in.CustomFields;
import com.qiwi.billpayments.sdk.model.in.PaymentInfo;
import com.qiwi.billpayments.sdk.model.in.RefundBillRequest;
import com.qiwi.billpayments.sdk.model.out.BillResponse;
import com.qiwi.billpayments.sdk.model.out.RefundResponse;
import com.qiwi.billpayments.sdk.web.Get;
import com.qiwi.billpayments.sdk.web.Post;
import com.qiwi.billpayments.sdk.web.Put;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;

import java.net.URISyntaxException;
import java.util.Map;
import java.util.Optional;

public class BillPaymentClient {

    private static final String AUTHORIZATION_PREFIX = "Bearer ";
    private static final String CLIENT_NAME = "java_sdk";
    private static final String BILLS_URL = "https://api.qiwi.com/partner/bill/v1/bills/";
    private static final String PAYMENT_URL = "https://oplata.qiwi.com/create";
    private static final String APP_VERSION = PomInfo.VERSION;

    private final RequestMapperNode requestMapperNode = new RequestMapperNode();
    private final Map<String, String> headers;

    public BillPaymentClient(String secretKey) {
        this.headers = prepareHeaders(secretKey);
    }

    static Map<String, String> prepareHeaders(String bearerToken) {
        return Map.of(
                HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString(),
                HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.toString(),
                HttpHeaders.AUTHORIZATION, AUTHORIZATION_PREFIX + bearerToken
        );
    }
    
    @SneakyThrows
    public BillResponse createBill(CreateBillInfo info) {
        BillResponse response = requestMapperNode.request(
                new Put(),
                BILLS_URL + info.getBillId(),
                appendCustomFields(info),
                BillResponse.class,
                headers
        );
        return new SuccessURLAppender(response, info.getSuccessUrl()).get();
    }
    
    private CreateBillRequest appendCustomFields(CreateBillInfo info) {
        return CreateBillRequest.create(
                info,
                new CustomFields(
                        CLIENT_NAME,
                        null,
                        null,
                        info.getThemeCode(),
                        info.getPaySourcesFilter()
                )
        );
    }

    public BillResponse getBillInfo(String billId) {
        return requestMapperNode.request(
                new Get(),
                BILLS_URL + billId,
                BillResponse.class,
                headers
        );
    }

    public BillResponse cancelBill(String billId) {
        return requestMapperNode.request(
                new Post(),
                BILLS_URL + billId + "/reject",
                BillResponse.class,
                headers
        );
    }

    public RefundResponse refundBill(String billId, String refundId, MoneyAmount amount) {
        return requestMapperNode.request(
                new Put(),
                BILLS_URL + billId + "/refunds/" + refundId,
                new RefundBillRequest(amount),
                RefundResponse.class,
                headers
        );
    }

    public RefundResponse getRefundInfo(String billId, String refundId) {
        return requestMapperNode.request(
                new Get(),
                BILLS_URL + billId + "/refunds/" + refundId,
                RefundResponse.class,
                headers
        );
    }

    public String createPaymentForm(PaymentInfo paymentInfo) {
        try {
            return new URIBuilder(PAYMENT_URL)
                    .addParameter("amount", paymentInfo.getAmount().formatValue())
                    .addParameter("customFields[apiClient]", CLIENT_NAME)
                    .addParameter("customFields[apiClientVersion]", APP_VERSION)
                    .addParameter("customFields[themeCode]", paymentInfo.getThemeCode())
                    .addParameter("publicKey", paymentInfo.getPublicKey())
                    .addParameter("billId", paymentInfo.getBillId())
                    .addParameter("successUrl", paymentInfo.getSuccessUrl())
                    .build()
                    .toString();

        } catch (URISyntaxException e) {
            throw new UrlEncodingException(e);
        }
    }

    public static String getAppVersion() {
        return APP_VERSION;
    }
}
