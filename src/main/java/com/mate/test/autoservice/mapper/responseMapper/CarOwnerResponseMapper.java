package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.CarOwnerResponseDto;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.model.Order;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class CarOwnerResponseMapper implements ResponseMapper<CarOwner, CarOwnerResponseDto> {
    @Override
    public CarOwnerResponseDto toDto(CarOwner model) {
        CarOwnerResponseDto carOwnerResponseDto = new CarOwnerResponseDto();
        carOwnerResponseDto.setCarsId(model.getCars()
                .stream()
                .map(Car :: getId)
                .collect(Collectors.toList()));
        carOwnerResponseDto.setOrdersId(model.getOrders()
                .stream()
                .map(Order :: getId)
                .collect(Collectors.toList()));
        return carOwnerResponseDto;
    }
}
