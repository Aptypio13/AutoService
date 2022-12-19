package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.PaymentStatus;
public interface TaskService<T> {
    T add(T entity);

    T updateTaskStatus(Long taskId, PaymentStatus paymentStatus);

    T getTaskById(Long id);

}
