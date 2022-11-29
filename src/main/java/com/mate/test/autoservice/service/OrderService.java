package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;

import java.util.List;
public interface OrderService<T> {
    List<T> getAllByOwnerId(Long id);

    Double getTotalCostById(Long id);

    void add(T t);

    void addProduct(Product product, Long id);

    T getOrderById(Long id);

    void updateOrderStatus(Long orderId, OrderStatus status);
}

