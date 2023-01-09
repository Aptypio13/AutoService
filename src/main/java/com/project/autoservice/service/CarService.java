package com.project.autoservice.service;

public interface CarService<T> {
    T add(T entity);

    T getById(Long id);

    T update(Long id, T entity);
}
