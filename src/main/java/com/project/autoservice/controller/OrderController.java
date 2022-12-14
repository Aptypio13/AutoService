package com.project.autoservice.controller;

import com.project.autoservice.dto.request.OrderRequestDto;
import com.project.autoservice.dto.response.OrderResponseDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService<Order> orderService;
    private final RequestMapper<Order, OrderRequestDto> requestMapper;
    private final ResponseMapper<Order, OrderResponseDto> responseOrderMapper;

    @PostMapping()
    @Operation(description = "save order to DB")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto order) {
        return responseOrderMapper.toDto(orderService.add(requestMapper.toModel(order)));
    }

    @PatchMapping("/{id}/{productId}")
    @Operation(description = "add a product to order")
    public OrderResponseDto addProductToOrder(
            @PathVariable Long id,
            @PathVariable Long productId) {
        return responseOrderMapper.toDto(orderService.addProduct(id, productId));
    }

    @PutMapping("/{id}")
    @Operation(description = "update order information")
    public OrderResponseDto updateOrder(@PathVariable Long id, @RequestBody OrderRequestDto order) {
        return responseOrderMapper.toDto(orderService.update(id, requestMapper.toModel(order)));
    }

    @PatchMapping("/{id}")
    @Operation(description = "update order status")
    public OrderResponseDto updateOrderStatus(
            @PathVariable Long id,@RequestBody OrderStatus status) {
        return responseOrderMapper.toDto(orderService.updateOrderStatus(id, status));
    }

    @GetMapping("/total-price")
    @Operation(description = "get a total price of order")
    public Double getTotalPrice(Long id) {
        return orderService.getTotalCostById(id);
    }
}
