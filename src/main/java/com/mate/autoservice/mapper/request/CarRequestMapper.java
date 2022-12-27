package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.CarRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Car;
import com.mate.autoservice.model.CarOwner;
import com.mate.autoservice.service.CarOwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarRequestMapper implements RequestMapper<Car, CarRequestDto> {
    private final CarOwnerService<CarOwner> ownerService;

    @Override
    public Car toModel(CarRequestDto dto) {
        Car car = new Car();
        car.setModel(dto.getModel());
        car.setMark(dto.getMark());
        car.setOwner(ownerService.getById(dto.getOwnerId()));
        car.setNumber(dto.getNumber());
        car.setYearOfManufacture(dto.getYearOfManufacture());
        return car;
    }
}
