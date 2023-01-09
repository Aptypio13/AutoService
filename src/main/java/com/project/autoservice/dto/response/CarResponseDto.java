package com.project.autoservice.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String mark;
    private String model;
    private LocalDate yearOfManufacture;
    private String number;
    private Long ownerId;
}
