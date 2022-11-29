package com.mate.test.autoservice.model;

public enum TypeOfTask {
    DIAGNOSTICS("Diagnostics"),
    OIL_CHANGE("OilChange"),
    ENGINE_REPAIR("EnginRepair"),
    GRM_CHANGE("GRMChange");

    private String value;
    TypeOfTask(String value) {
        this.value = value;
    }
}
