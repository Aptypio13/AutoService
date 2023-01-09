package com.project.autoservice.mapper.response;

import com.project.autoservice.dto.response.OrderResponseDto;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.Product;
import com.project.autoservice.model.Task;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderResponseMapper implements ResponseMapper<Order, OrderResponseDto> {
    @Override
    public OrderResponseDto toDto(Order model) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setCar(model.getCar());
        dto.setId(model.getId());
        dto.setTotalCost(model.getTotalCost());
        dto.setOrderStatus(model.getOrderStatus());
        dto.setTasksId(model.getTasks().stream().map(Task::getId).collect(Collectors.toList()));
        dto.setDateOfApplication(model.getDateOfApplication());
        dto.setDateOfCompletion(model.getDateOfCompletion());
        dto.setDescriptionOfProblem(model.getDescriptionOfProblem());
        dto.setProductsId(model.getProducts().stream().map(Product ::getId).collect(Collectors.toList()));
        return dto;
    }
}
