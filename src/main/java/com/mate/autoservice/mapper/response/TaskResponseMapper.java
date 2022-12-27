package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.TaskResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Task;
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
