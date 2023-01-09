package com.project.autoservice.mapper.response;

import com.project.autoservice.dto.response.CarResponseDto;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Car;
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
