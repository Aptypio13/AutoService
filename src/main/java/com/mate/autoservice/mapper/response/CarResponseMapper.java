package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.CarResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Car;
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
