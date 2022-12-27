package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.CarOwnerRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Car;
import com.mate.autoservice.model.CarOwner;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.service.CarService;
import com.mate.autoservice.service.OrderService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
                .map(orderService:: getById)
                .collect(Collectors.toList()));
        return carOwner;
    }
}
