package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.CarRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarRequestMapper implements RequestMapper<Car, CarRequestDto> {
    @Override
    public Car toModel(CarRequestDto dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setMark(dto.getMark());
        car.setOwner(dto.getOwner());
        car.setNumber(dto.getNumber());
        car.setYearOfManufacture(dto.getYearOfManufacture());
        return car;
    }
}
