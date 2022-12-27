package com.mate.autoservice.controller;

import com.mate.autoservice.dto.request.CarOwnerRequestDto;
import com.mate.autoservice.dto.response.CarOwnerResponseDto;
import com.mate.autoservice.dto.response.OrderResponseDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.CarOwner;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.service.CarOwnerService;
import com.mate.autoservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CarOwnerResponseDto updateCarOwner(
            @PathVariable Long id, @RequestBody CarOwnerRequestDto carOwner) {
        return responseCarOwnerMapper
                .toDto(carOwnerService.update(id, requestMapper.toModel(carOwner)));
    }

    @GetMapping("/orders/{id}")
    @Operation(description = "get all owner orders")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        return orderService.getAllByOwnerId(id)
                .stream()
                .map(responseOrderMapper::toDto)
                .collect(Collectors.toList());
    }
}
