package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.CarOwnerRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.service.CarService;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CarOwnerRequestMapper implements RequestMapper<CarOwner, CarOwnerRequestDto> {
    private final CarService<Car> carService;
    private final OrderService<Order> orderService;
    @Override
    public CarOwner toModel(CarOwnerRequestDto dto) {
        CarOwner carOwner = new CarOwner();
        carOwner.setCars(dto.getCarsId()
                .stream()
                .map(carService::getById)
                .collect(Collectors.toList()));
        carOwner.setOrders(dto.getOrdersId()
                .stream()
                .map(orderService::getOrderById)
                .collect(Collectors.toList()));
        return carOwner;
    }
}
