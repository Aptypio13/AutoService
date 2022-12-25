package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.TaskRequestDto;
import com.mate.test.autoservice.dto.responseDto.TaskResponseDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.PaymentStatus;
import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {
    private final TaskService<Task> taskService;
    private final RequestMapper<Task, TaskRequestDto> requestMapper;
    private final ResponseMapper<Task, TaskResponseDto> responseMapper;

    @PostMapping()
    @Operation(description = "save task to DB")
    public TaskResponseDto createTask(@RequestBody TaskRequestDto task) {
        return responseMapper.toDto(taskService.add(requestMapper.toModel(task)));
    }

    @PutMapping("/{id}")
    @Operation(description = "update task information")
    public TaskResponseDto updateTask(@PathVariable Long id, @RequestBody TaskRequestDto task) {
        return responseMapper.toDto(taskService.add(requestMapper.toModel(task)));
    }

    @PatchMapping("/{id}")
    @Operation(description = "update task status")
    public TaskResponseDto updateTaskStatus(@PathVariable Long id, @RequestBody PaymentStatus status) {
        return responseMapper.toDto(taskService.updateTaskStatus(id, status));
    }
}
