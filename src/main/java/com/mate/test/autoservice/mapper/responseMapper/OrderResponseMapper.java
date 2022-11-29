package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.OrderResponseDto;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Order;
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
