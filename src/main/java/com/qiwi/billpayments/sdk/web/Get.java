package com.qiwi.billpayments.sdk.web;

import okhttp3.Request;

import java.net.URL;

public class Get implements RequestType {

    @Override
    public Request.Builder apply(Request.Builder builder, String s) {
        return builder.get();
    }
}
