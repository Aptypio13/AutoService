package com.project.autoservice.controller;

import com.project.autoservice.dto.request.TaskRequestDto;
import com.project.autoservice.dto.response.TaskResponseDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.Task;
import com.project.autoservice.service.TaskService;
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
@RequestMapping("/tasks")
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
        return responseMapper.toDto(taskService.update(id, requestMapper.toModel(task)));
    }

    @PatchMapping("/{id}")
    @Operation(description = "update task status")
    public TaskResponseDto updateTaskStatus(
            @PathVariable Long id, @RequestBody PaymentStatus status) {
        return responseMapper.toDto(taskService.updateTaskStatus(id, status));
    }
}
