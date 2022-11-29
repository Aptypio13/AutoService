package com.mate.test.autoservice.model;

public enum OrderStatus {
    RECEIVED("Received"),
    IN_PROCESS("in process"),
    SUCCESSFUL_DONE("successful done"),
    NOT_SUCCESSFUL_DONE("unsuccessful done"),
    PAID("paid");
    private String value;

    OrderStatus (String value){
        this.value = value;
    }
}
