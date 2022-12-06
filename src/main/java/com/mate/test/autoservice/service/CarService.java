package com.mate.test.autoservice.service;

public interface CarService<T> {
    void add(T t);
    T getById(Long id);
}
