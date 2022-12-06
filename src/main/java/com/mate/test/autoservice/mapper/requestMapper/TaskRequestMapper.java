package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.TaskRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.service.MechanicService;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskRequestMapper implements RequestMapper<Task, TaskRequestDto> {
    private final MechanicService<Mechanic> mechanicService;
    private final OrderService<Order> orderService;
    @Override
    public Task toModel(TaskRequestDto dto) {
        Task task = new Task();
        task.setMechanic(mechanicService.getById(dto.getMechanicId()));
        task.setOrder(orderService.getOrderById(dto.getOrderId()));
        task.setTypeOfTask(dto.getTypeOfTask());
        task.setPrice(dto.getPrice());
        task.setPaymentStatus(dto.getPaymentStatus());
        return task;
    }
}
