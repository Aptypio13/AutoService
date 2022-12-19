package com.mate.test.autoservice.service.impl;

import java.time.LocalDate;
import java.util.List;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.model.TypeOfTask;
import com.mate.test.autoservice.repository.OrderRepository;
import com.mate.test.autoservice.service.OrderService;
import com.mate.test.autoservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService<Order> {
    private final OrderRepository orderRepository;
    private final ProductService<Product> productService;
    private static final Double DISCOUNT_FOR_TASK = 0.2;
    private static final Double DISCOUNT_FOR_PRODUCT = 0.1;
    private static final Double DIAGNOSTIC_PRICE_WITHOUT_TASKS = 500.0;

    @Override
    public List<Order> getAllByOwnerId(Long id) {
        return orderRepository.findAllByCar_OwnerId(id);
    }

    @Override
    public Double getTotalCostById(Long id) {
        Order order = getById(id);
        int countOfOrdersOfThisOwner = order.getCar().getOwner().getOrders().size();
        if (isDiagnostic(order) && order.getTasks().size() <= 1) {
            return DIAGNOSTIC_PRICE_WITHOUT_TASKS;
        }
        if (countOfOrdersOfThisOwner > 0) {
            double discount = (countOfOrdersOfThisOwner * DISCOUNT_FOR_TASK) +
                    (countOfOrdersOfThisOwner * DISCOUNT_FOR_PRODUCT);
            return order.getTotalCost() - discount ;
        }
        return order.getTotalCost();
    }

    private boolean isDiagnostic(Order order) {
        return order.getTasks().stream().anyMatch(t -> t.getTypeOfTask() == TypeOfTask.DIAGNOSTICS);
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addProduct(Long orderId, Long productId) {
        Order order = getById(orderId);
        order.getProducts().add(productService.getById(productId));
        return orderRepository.save(order);
    }


    @Override
    public Order getById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "No such order with id: " + id));
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = getById(orderId);
        order.setOrderStatus(status);
        if (order.getOrderStatus() == OrderStatus.SUCCESSFUL_DONE ||
        order.getOrderStatus() == OrderStatus.NOT_SUCCESSFUL_DONE) {
            order.setDateOfCompletion(LocalDate.now());
        }
        return add(order);
    }

    @Override
    public Order update(Long id, Order entity) {
        Order order = getById(id);
        order.setOrderStatus(entity.getOrderStatus());
        order.setProducts(entity.getProducts());
        order.setCar(entity.getCar());
        order.setTasks(entity.getTasks());
        order.setDateOfApplication(order.getDateOfApplication());
        order.setDateOfCompletion(entity.getDateOfCompletion());
        order.setDescriptionOfProblem(entity.getDescriptionOfProblem());
        order.setTotalCost(order.getTotalCost());
        return orderRepository.save(order);
    }
}
