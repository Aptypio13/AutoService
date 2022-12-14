package com.project.autoservice.service;

import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import java.util.List;

public interface OrderService<T> {
    List<T> getAllByOwnerId(Long id);

    Double getTotalCostById(Long id);

    T add(T entity);

    Order addProduct(Long orderId, Long productId);

    T getById(Long id);

    T updateOrderStatus(Long orderId, OrderStatus status);

    T update(Long id, T entity);
}

