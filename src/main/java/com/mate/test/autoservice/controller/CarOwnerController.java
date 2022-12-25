package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.CarOwnerRequestDto;
import com.mate.test.autoservice.dto.responseDto.CarOwnerResponseDto;
import com.mate.test.autoservice.dto.responseDto.OrderResponseDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.service.CarOwnerService;
import com.mate.test.autoservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
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
    private final ResponseMapper<Order, OrderResponseDto> responseOrderMapper;
    private final ResponseMapper<CarOwner, CarOwnerResponseDto> responseCarOwnerMapper;

    @PostMapping()
    @Operation(description = "save car owner to DB")
    public CarOwnerResponseDto createCarOwner(@RequestBody CarOwnerRequestDto carOwner) {
        return responseCarOwnerMapper.toDto(carOwnerService.add(requestMapper.toModel(carOwner)));
    }

    @PutMapping("/{id}")
    @Operation(description = "update owner information")
    public CarOwnerResponseDto updateCarOwner(@PathVariable Long id, @RequestBody CarOwnerRequestDto carOwner) {
        return responseCarOwnerMapper.toDto(carOwnerService.update(id, requestMapper.toModel(carOwner)));
    }

    @GetMapping("/orders/{id}")
    @Operation(description = "get all owner orders")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        return orderService.getAllByOwnerId(id)
                .stream()
                .map(responseOrderMapper ::toDto)
                .collect(Collectors.toList());
    }
}
