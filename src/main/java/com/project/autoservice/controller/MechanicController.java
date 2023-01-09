package com.project.autoservice.controller;

import com.project.autoservice.dto.request.MechanicRequestDto;
import com.project.autoservice.dto.response.MechanicResponseDto;
import com.project.autoservice.dto.response.OrderResponseDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import com.project.autoservice.service.MechanicService;
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
@RequestMapping("/mechanics")
@AllArgsConstructor
public class MechanicController {
    private final MechanicService<Mechanic> mechanicService;
    private final RequestMapper<Mechanic, MechanicRequestDto> requestMapper;
    private final ResponseMapper<Order, OrderResponseDto> responseOrderMapper;
    private final ResponseMapper<Mechanic, MechanicResponseDto> responseMechanicMapper;

    @PostMapping()
    @Operation(description = "save mechanic to DB")
    public MechanicResponseDto createMechanic(@RequestBody MechanicRequestDto mechanic) {
        return responseMechanicMapper.toDto(mechanicService.add(requestMapper.toModel(mechanic)));
    }

    @PutMapping("/{id}")
    @Operation(description = "update mechanic information")
    public MechanicResponseDto updateMechanic(
            @PathVariable Long id, @RequestBody MechanicRequestDto mechanic) {
        return responseMechanicMapper
                .toDto(mechanicService.update(id, requestMapper.toModel(mechanic)));
    }

    @GetMapping("/{id}/orders")
    @Operation(description = "get all mechanic orders")
    public List<OrderResponseDto> getOrders(@PathVariable Long id) {
        return mechanicService
                .getOrdersByMechanicId(id)
                .stream()
                .map(responseOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}/salary")
    @Operation(description = "get mechanic salary")
    public Double getMechanicSalaryById(@PathVariable Long id) {
        return mechanicService.getSalaryById(id);
    }
}
