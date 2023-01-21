package com.qiwi.billpayments.sdk.web;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.net.URL;

public class Post implements RequestType {
    
    private final MediaType mediaType = MediaType.get("application/json; charset=utf-8");

    @Override
    public Request.Builder apply(Request.Builder builder, String s) {
        return builder.post(RequestBody.create(s, this.mediaType));
    }
    
}
