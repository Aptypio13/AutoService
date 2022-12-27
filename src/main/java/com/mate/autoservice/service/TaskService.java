package com.mate.autoservice.service;

import com.mate.autoservice.model.PaymentStatus;

public interface TaskService<T> {
    T add(T entity);

    T updateTaskStatus(Long taskId, PaymentStatus paymentStatus);

    T getTaskById(Long id);

    T update(Long id, T entity);
}
