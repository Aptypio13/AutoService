package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;

import java.util.List;
public interface MechanicService<T> {
    T add(T entity);

    List<Order> getOrdersByMechanicId(Long id);

    Mechanic getById(Long id);

    Double getSalaryById(Long id);

    T update(Long id, T entity);
}
