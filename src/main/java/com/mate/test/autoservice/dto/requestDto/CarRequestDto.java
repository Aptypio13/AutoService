package com.mate.test.autoservice.dto.requestDto;

import java.time.LocalDate;
import lombok.Data;
import com.mate.test.autoservice.model.CarOwner;

@Data
public class CarRequestDto {
    private String mark;
    private String model;
    private LocalDate yearOfManufacture;
    private String number;
    private Long ownerId;
}
