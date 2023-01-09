package com.project.autoservice.service.impl;

import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.Product;
import com.project.autoservice.model.Task;
import com.project.autoservice.model.TypeOfTask;
import com.project.autoservice.repository.OrderRepository;
import com.project.autoservice.service.OrderService;
import com.project.autoservice.service.ProductService;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService<Order> {
    private static final Double DISCOUNT_FOR_TASK = 0.2;
    private static final Double DISCOUNT_FOR_PRODUCT = 0.1;
    private static final Double DIAGNOSTIC_PRICE_WITHOUT_TASKS = 500.0;
    private final OrderRepository<Order> orderRepository;
    private final ProductService<Product> productService;

    @Override
    public List<Order> getAllByOwnerId(Long id) {
        return orderRepository.findAllByCarOwnerId(id);
    }

    @Override
    public Double getTotalCostById(Long id) {
        Order order = getById(id);
        int countOfOrdersOfThisOwner = order.getCar().getOwner().getOrders().size();
        if (isDiagnostic(order) && order.getTasks().size() <= 1) {
            return DIAGNOSTIC_PRICE_WITHOUT_TASKS;
        }
        if (countOfOrdersOfThisOwner > 0) {
            double discount = (countOfOrdersOfThisOwner * DISCOUNT_FOR_TASK)
                    + (countOfOrdersOfThisOwner * DISCOUNT_FOR_PRODUCT);
            return getTotalCost(order.getProducts(), order.getTasks()) - discount;
        }
        return getTotalCost(order.getProducts(), order.getTasks());
    }

    @Override
    public Order add(@NonNull Order order) {
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
    public Order updateOrderStatus(@NotNull Long orderId,@NotNull OrderStatus status) {
        Order order = getById(orderId);
        order.setOrderStatus(status);
        if (order.getOrderStatus() == OrderStatus.SUCCESSFUL_DONE
                || order.getOrderStatus() == OrderStatus.NOT_SUCCESSFUL_DONE) {
            order.setDateOfCompletion(LocalDate.now());
        }
        return add(order);
    }

    @Override
    public Order update(Long id, @NonNull Order entity) {
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

    private boolean isDiagnostic(Order order) {
        return order.getTasks().stream().anyMatch(t -> t.getTypeOfTask() == TypeOfTask.DIAGNOSTICS);
    }

    private Double getTotalCost(List<Product> products, List<Task> tasks) {
        double productsCost = products
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
        double tasksCost = tasks
                .stream()
                .filter(task -> task.getPaymentStatus() != PaymentStatus.PAID)
                .mapToDouble(Task::getPrice)
                .sum();
        return productsCost + tasksCost;
    }
}
