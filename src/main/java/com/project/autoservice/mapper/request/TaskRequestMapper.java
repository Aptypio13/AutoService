package com.project.autoservice.mapper.request;

import com.project.autoservice.dto.request.TaskRequestDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.Task;
import com.project.autoservice.service.MechanicService;
import com.project.autoservice.service.OrderService;
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
        task.setOrder(orderService.getById(dto.getOrderId()));
        task.setTypeOfTask(dto.getTypeOfTask());
        task.setPrice(dto.getPrice());
        task.setPaymentStatus(dto.getPaymentStatus());
        return task;
    }
}
