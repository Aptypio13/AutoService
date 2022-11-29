package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.TaskRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestMapper implements RequestMapper<Task, TaskRequestDto> {
    @Override
    public Task toModel(TaskRequestDto dto) {
        Task task = new Task();
        task.setMechanic(dto.getMechanic());
        task.setOrder(dto.getOrder());
        task.setTypeOfTask(dto.getTypeOfTask());
        task.setPrice(dto.getPrice());
        task.setPaymentStatus(dto.getPaymentStatus());
        return task;
    }
}
