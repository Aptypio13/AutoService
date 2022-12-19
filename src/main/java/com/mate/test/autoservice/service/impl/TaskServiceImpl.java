package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.PaymentStatus;
import com.mate.test.autoservice.model.Task;
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
    public Task add(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public Task updateTaskStatus(Long taskId, PaymentStatus status) {
        Task task = getTaskById(taskId);
        task.setPaymentStatus(status);
        return add(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "No such task with id: " + id)
                );
    }
}
