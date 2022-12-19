package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.TaskResponseDto;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskResponseMapper implements ResponseMapper<Task, TaskResponseDto> {
    @Override
    public TaskResponseDto toDto(Task model) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTypeOfTask(model.getTypeOfTask());
        taskResponseDto.setId(model.getId());
        taskResponseDto.setPrice(model.getPrice());
        taskResponseDto.setOrderId(model.getOrder().getId());
        taskResponseDto.setMechanicId(model.getMechanic().getId());
        taskResponseDto.setPaymentStatus(model.getPaymentStatus());
        return taskResponseDto;
    }
}
