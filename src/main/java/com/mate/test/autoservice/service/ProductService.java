package com.mate.test.autoservice.service;

public interface ProductService<T> {
    T add(T entity);
    T getById(Long id);

    T update(Long id, T entity);
}
