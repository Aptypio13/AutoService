package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.CarOwnerResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Car;
import com.mate.autoservice.model.CarOwner;
import com.mate.autoservice.model.Order;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarOwnerResponseMapper implements ResponseMapper<CarOwner, CarOwnerResponseDto> {
    @Override
    public CarOwnerResponseDto toDto(CarOwner model) {
        CarOwnerResponseDto carOwnerResponseDto = new CarOwnerResponseDto();
        carOwnerResponseDto.setCarsId(model.getCars()
                .stream()
                .map(Car::getId)
                .collect(Collectors.toList()));
        carOwnerResponseDto.setOrdersId(model.getOrders()
                .stream()
                .map(Order::getId)
                .collect(Collectors.toList()));
        return carOwnerResponseDto;
    }
}
