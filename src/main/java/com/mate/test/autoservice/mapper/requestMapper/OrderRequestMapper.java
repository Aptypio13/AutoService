package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.OrderRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.service.CarService;
import com.mate.test.autoservice.service.ProductService;
import com.mate.test.autoservice.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
        /** посчитать общую стоимость заказа в сервисе */
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
