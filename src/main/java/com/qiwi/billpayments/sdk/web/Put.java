package com.qiwi.billpayments.sdk.web;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Put implements RequestType {

    private final MediaType mediaType = MediaType.get("application/json; charset=utf-8");

    @Override
    public Request.Builder apply(Request.Builder builder, String s) {
        return builder.put(RequestBody.create(s, this.mediaType));
    }

}