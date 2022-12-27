package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.OrderRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Car;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.model.OrderStatus;
import com.mate.autoservice.model.Product;
import com.mate.autoservice.model.Task;
import com.mate.autoservice.service.CarService;
import com.mate.autoservice.service.ProductService;
import com.mate.autoservice.service.TaskService;
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
        order.setTotalCost(1000.0);
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
