package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.CarOwnerRequestDto;
import com.mate.test.autoservice.dto.responseDto.OrderResponseDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.service.CarOwnerService;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
@AllArgsConstructor
public class CarOwnerController {
    private final CarOwnerService<CarOwner> carOwnerService;
    private final OrderService<Order> orderService;
    private final RequestMapper<CarOwner, CarOwnerRequestDto> requestMapper;
    private final ResponseMapper<Order, OrderResponseDto> responseMapper;

    @PostMapping("/add")
    public void createCarOwner(@RequestBody CarOwnerRequestDto carOwner) {
        carOwnerService.add(requestMapper.toModel(carOwner));
    }

    @PutMapping("/update")
    public void updateCarOwner(@RequestBody CarOwnerRequestDto carOwner) {
        carOwnerService.add(requestMapper.toModel(carOwner));
    }

    @GetMapping("/orders/{id}")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        return orderService.getAllByOwnerId(id)
                .stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }
}
