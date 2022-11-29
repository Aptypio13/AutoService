package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.OrderRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements RequestMapper<Order, OrderRequestDto> {
    @Override
    public Order toModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(dto.getCar());
        order.setTotalCost(dto.getTotalCost());
        order.setOrderStatus(dto.getOrderStatus());
        order.setProducts(dto.getProducts());
        order.setTasks(dto.getTasks());
        order.setDateOfApplication(dto.getDateOfApplication());
        order.setDateOfCompletion(dto.getDateOfCompletion());
        order.setDescriptionOfProblem(dto.getDescriptionOfProblem());
        return order;
    }
}
