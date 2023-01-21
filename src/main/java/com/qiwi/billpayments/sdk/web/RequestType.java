package com.qiwi.billpayments.sdk.web;

import okhttp3.Request;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface RequestType extends BiFunction<Request.Builder, String, Request.Builder> {
}
