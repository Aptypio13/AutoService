package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.TypeOfTask;
public interface TaskService<T> {
    void add(T t);

    void updateTaskStatus(Long taskId, TypeOfTask task);

    T getTaskById(Long id);

}
