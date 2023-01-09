package com.project.autoservice.model;

public enum PaymentStatus {
    PAID("Paid"),
    NOT_PAID("NotPaid");
    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }
}
