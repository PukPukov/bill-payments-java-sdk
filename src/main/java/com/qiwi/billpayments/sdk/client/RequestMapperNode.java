package com.qiwi.billpayments.sdk.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.qiwi.billpayments.sdk.exception.BadResponseException;
import com.qiwi.billpayments.sdk.exception.ServerRespondedWithErrorException;
import com.qiwi.billpayments.sdk.json.BigDecimalSerializer;
import com.qiwi.billpayments.sdk.model.out.ErrorResponse;
import com.qiwi.billpayments.sdk.web.RequestType;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class RequestMapperNode {
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .registerModule(new SimpleModule().addSerializer(new BigDecimalSerializer()))
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    private final OkHttpClient httpClient = new OkHttpClient();
    
    @SneakyThrows
    public <T> T request(
            RequestType requestType,
            String URL,
            Object data,
            Class<T> responseClass,
            Map<String, String> headers
    ) {
        Request.Builder builder = new Request.Builder();
        String json = mapper.writeValueAsString(data);
        builder = requestType.apply(builder, json);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder = builder.addHeader(entry.getKey(), entry.getValue());
        }
        builder.url(URL);
        Request request = builder.build();
        Response response = httpClient.newCall(request).execute();
        return this.deserializeResponseBody(responseClass, response);
    }
    
    public <T> T request(
            RequestType requestType,
            String URL,
            Class<T> defineResponseAs,
            Map<String, String> headers
    ) {
        return this.request(requestType, URL, null, defineResponseAs, headers);
    }

    @SneakyThrows
    private <T> T deserializeResponseBody(Class<T> responseClass, Response response) {
        Class<T> operatedClass = responseClass;
        String body = response.body().string();
        int code = response.code();
        try {
            if (response.code() != 200) {
                operatedClass = (Class<T>) ErrorResponse.class;
                throw new ServerRespondedWithErrorException(
                        !body.equals("") ? mapper.readValue(body, (Class<ErrorResponse>) operatedClass) : null,
                        code
                );
            }
            return mapper.readValue(body, operatedClass);
        } catch (JsonProcessingException exception) {
            throw new BadResponseException(body, code, operatedClass, exception.getMessage());
        }
    }
    
}
