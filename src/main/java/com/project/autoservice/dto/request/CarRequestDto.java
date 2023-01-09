package com.project.autoservice.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CarRequestDto {
    private String mark;
    private String model;
    private LocalDate yearOfManufacture;
    private String number;
    private Long ownerId;
}
