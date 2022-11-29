package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.TaskRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.model.TypeOfTask;
import com.mate.test.autoservice.service.TaskService;
import lombok.AllArgsConstructor;
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

    @PostMapping("/add")
    public void createTask(@RequestBody TaskRequestDto task) {
        taskService.add(requestMapper.toModel(task));
    }

    @PutMapping("/update")
    public void updateTask(@RequestBody TaskRequestDto task) {
        taskService.add(requestMapper.toModel(task));
    }

    @PutMapping("/update/status/{taskId}")
    public void updateTaskStatus(@PathVariable Long taskId, @RequestBody TypeOfTask task) {
        taskService.updateTaskStatus(taskId, task);
    }
}
