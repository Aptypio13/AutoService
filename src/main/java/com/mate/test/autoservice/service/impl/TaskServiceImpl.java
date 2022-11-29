package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.model.TypeOfTask;
import com.mate.test.autoservice.repository.TaskRepository;
import com.mate.test.autoservice.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService<Task> {
    private final TaskRepository<Task> taskRepository;

    public TaskServiceImpl(TaskRepository<Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTaskStatus(Long taskId, TypeOfTask taskType) {
        Task task = getTask(taskId);
        task.setTypeOfTask(taskType);
        add(task);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "No such task with id: " + id)
                );
    }
}
