package com.project.autoservice.model;

import lombok.Getter;

public enum TypeOfTask {
    DIAGNOSTICS("Diagnostics"),
    OIL_CHANGE("OilChange"),
    ENGINE_REPAIR("EnginRepair"),
    GRM_CHANGE("GRMChange");

    @Getter
    private final String value;
    TypeOfTask(String value) {
        this.value = value;
    }

}
