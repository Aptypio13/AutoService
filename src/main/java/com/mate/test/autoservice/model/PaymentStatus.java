package com.mate.test.autoservice.model;

public enum PaymentStatus {
    PAID("Paid"),
    NOT_PAID("NotPaid");
    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }
}
