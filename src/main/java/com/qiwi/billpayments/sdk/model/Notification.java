package com.qiwi.billpayments.sdk.model;

import lombok.*;

@Getter
@With
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Notification {

    private final Bill bill;
    private final String version;

}
