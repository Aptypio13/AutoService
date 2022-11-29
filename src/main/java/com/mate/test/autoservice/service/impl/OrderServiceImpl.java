package com.mate.test.autoservice.service.impl;

import java.util.List;

import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.repository.OrderRepository;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService<Order> {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllByOwnerId(Long id) {
        return orderRepository.findAllByCar_OwnerId(id);
    }

    @Override
    public Double getTotalCostById(Long id) {
        return getOrderById(id).getTotalCost();

    }

    @Override
    public void add(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void addProduct(Product product, Long id) {
        Order order = getOrderById(id);
        List<Product> products = order.getProducts();
        products.add(product);
        order.setProducts(products);
        add(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "No such order with id: " + id));
    }

    @Override
    public void updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getOrderById(orderId);
        order.setOrderStatus(status);
        add(order);
    }
}
