package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.TaskRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Mechanic;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.model.Task;
import com.mate.autoservice.service.MechanicService;
import com.mate.autoservice.service.OrderService;
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
