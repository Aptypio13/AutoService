package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.CarResponseDto;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.mapper.ResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class CarResponseMapper implements ResponseMapper<Car, CarResponseDto> {
    @Override
    public CarResponseDto toDto(Car model) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setMark(model.getMark());
        carResponseDto.setNumber(model.getNumber());
        carResponseDto.setModel(model.getModel());
        carResponseDto.setId(model.getId());
        carResponseDto.setOwnerId(model.getOwner().getId());
        carResponseDto.setYearOfManufacture(model.getYearOfManufacture());
        return carResponseDto;
    }
}
