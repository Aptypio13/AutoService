package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.OrderRequestDto;
import com.mate.test.autoservice.dto.requestDto.ProductRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final RequestMapper<Order, OrderRequestDto> orderRequestMapper;
    private final RequestMapper<Product, ProductRequestDto> productRequestMapper;

    @PostMapping("/add")
    public void createOrder(@RequestBody OrderRequestDto order) {
        orderService.add(orderRequestMapper.toModel(order));
    }

    @PostMapping("/add/{id}")
    public void addProductToOrder(@RequestBody ProductRequestDto product,@PathVariable Long id) {
        orderService.addProduct(productRequestMapper.toModel(product), id);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody OrderRequestDto order) {
        orderService.add(orderRequestMapper.toModel(order));
    }

    @PutMapping("/update/{orderId}&{status}")
    public void updateOrderStatus(@PathVariable Long orderId,@PathVariable OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
    }

    @GetMapping("/total-price")
    public Double getTotalCost(Long id) {
        return orderService.getTotalCostById(id);
    }
}
