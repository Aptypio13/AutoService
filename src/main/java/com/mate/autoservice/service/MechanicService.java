package com.mate.autoservice.service;

import com.mate.autoservice.model.Mechanic;
import com.mate.autoservice.model.Order;
import java.util.List;

public interface MechanicService<T> {
    T add(T entity);

    List<Order> getOrdersByMechanicId(Long id);

    Mechanic getById(Long id);

    Double getSalaryById(Long id);

    T update(Long id, T entity);
}
