package com.qiwi.billpayments.sdk.model;

import lombok.*;

@Getter
@With
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseData {

    private final String body;
    private final int httpStatus;

}
