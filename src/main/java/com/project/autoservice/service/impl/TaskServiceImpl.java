package com.project.autoservice.service.impl;

import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.Task;
import com.project.autoservice.repository.TaskRepository;
import com.project.autoservice.service.TaskService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService<Task> {
    private final TaskRepository<Task> taskRepository;

    public TaskServiceImpl(TaskRepository<Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(@NonNull Task entity) {
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

    @Override
    public Task update(Long id,@NonNull Task entity) {
        Task taskById = getTaskById(id);
        taskById.setTypeOfTask(entity.getTypeOfTask());
        taskById.setMechanic(entity.getMechanic());
        taskById.setOrder(entity.getOrder());
        taskById.setPrice(entity.getPrice());
        taskById.setPaymentStatus(entity.getPaymentStatus());
        return taskRepository.save(taskById);
    }
}
