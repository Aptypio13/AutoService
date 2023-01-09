package com.project.autoservice.model;

public enum OrderStatus {
    RECEIVED("Received"),
    REFUSED("Refused"),
    IN_PROCESS("In process"),
    SUCCESSFUL_DONE("Successful done"),
    NOT_SUCCESSFUL_DONE("Unsuccessful done"),
    PAID("Paid");
    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }
}
