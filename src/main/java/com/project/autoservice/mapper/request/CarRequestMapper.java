package com.project.autoservice.mapper.request;

import com.project.autoservice.dto.request.CarRequestDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.model.Car;
import com.project.autoservice.model.CarOwner;
import com.project.autoservice.service.CarOwnerService;
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
