package com.mate.test.autoservice.service;

public interface ProductService<T> {
    void add(T t);
    T getById(Long id);
}
