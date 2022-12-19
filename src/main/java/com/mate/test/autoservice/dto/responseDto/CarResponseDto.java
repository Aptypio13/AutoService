package com.mate.test.autoservice.dto.responseDto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CarResponseDto {
    private Long id;
    private String mark;
    private String model;
    private LocalDate yearOfManufacture;
    private String number;
    private Long ownerId;
}
