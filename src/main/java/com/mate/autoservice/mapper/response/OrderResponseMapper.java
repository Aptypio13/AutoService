package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.OrderResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements ResponseMapper<Order, OrderResponseDto> {
    @Override
    public OrderResponseDto toDto(Order model) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setCar(model.getCar());
        dto.setId(model.getId());
        dto.setTotalCost(model.getTotalCost());
        dto.setOrderStatus(model.getOrderStatus());
        dto.setTasks(model.getTasks());
        dto.setDateOfApplication(model.getDateOfApplication());
        dto.setDateOfCompletion(model.getDateOfCompletion());
        dto.setDescriptionOfProblem(model.getDescriptionOfProblem());
        dto.setProducts(model.getProducts());
        return dto;
    }
}
