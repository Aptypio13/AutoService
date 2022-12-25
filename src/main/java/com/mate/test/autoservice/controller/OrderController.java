package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.OrderRequestDto;
import com.mate.test.autoservice.dto.responseDto.OrderResponseDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.service.OrderService;
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
@RequestMapping("/order")
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

    @PatchMapping("/{orderId}/product={productId}")
    @Operation(description = "add a product to order")
    public OrderResponseDto addProductToOrder(
            @PathVariable Long orderId,
            @PathVariable Long productId) {
        return responseOrderMapper.toDto(orderService.addProduct(orderId, productId));
    }

    @PutMapping("/{id}")
    @Operation(description = "update order information")
    public OrderResponseDto updateOrder(@PathVariable Long id, @RequestBody OrderRequestDto order) {
        return responseOrderMapper.toDto(orderService.update(id, requestMapper.toModel(order)));
    }

    @PatchMapping("/{Id}")
    @Operation(description = "update order status")
    public OrderResponseDto updateOrderStatus(@PathVariable Long id,@RequestBody OrderStatus status) {
       return responseOrderMapper.toDto(orderService.updateOrderStatus(id, status));
    }

    @GetMapping("/total-price")
    @Operation(description = "get a total price of order")
    public Double getTotalCost(Long id) {
        return orderService.getTotalCostById(id);
    }
}
