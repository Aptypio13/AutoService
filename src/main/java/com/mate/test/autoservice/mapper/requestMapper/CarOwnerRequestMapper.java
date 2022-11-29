package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.CarOwnerRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.CarOwner;
import org.springframework.stereotype.Component;

@Component
public class CarOwnerRequestMapper implements RequestMapper<CarOwner, CarOwnerRequestDto> {
    @Override
    public CarOwner toModel(CarOwnerRequestDto dto) {
        CarOwner carOwner = new CarOwner();
        carOwner.setCars(dto.getCars());
        carOwner.setOrders(dto.getOrders());
        return carOwner;
    }
}
