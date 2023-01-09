package com.project.autoservice.mapper.request;

import com.project.autoservice.dto.request.OrderRequestDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.model.Car;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.model.Product;
import com.project.autoservice.model.Task;
import com.project.autoservice.service.CarService;
import com.project.autoservice.service.ProductService;
import com.project.autoservice.service.TaskService;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRequestMapper implements RequestMapper<Order, OrderRequestDto> {
    private final CarService<Car> carService;
    private final ProductService<Product> productService;
    private final TaskService<Task> taskService;

    @Override
    public Order toModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setCar(carService.getById(dto.getCarId()));
        order.setOrderStatus(OrderStatus.RECEIVED);
        order.setProducts(dto.getProductsId()
                .stream()
                .map(productService::getById)
                .collect(Collectors.toList()));
        order.setTasks(dto.getTasksId()
                .stream()
                .map(taskService:: getTaskById)
                .collect(Collectors.toList()));
        order.setDateOfApplication(dto.getDateOfApplication());
        order.setDateOfCompletion(dto.getDateOfCompletion());
        order.setDescriptionOfProblem(dto.getDescriptionOfProblem());
        return order;
    }
}
