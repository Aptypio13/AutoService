package com.mate.autoservice.dto.response;

import com.mate.autoservice.model.Car;
import com.mate.autoservice.model.OrderStatus;
import com.mate.autoservice.model.Product;
import com.mate.autoservice.model.Task;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Car car;
    private String descriptionOfProblem;
    private LocalDate dateOfApplication;
    private LocalDate dateOfCompletion;
    private List<Task> tasks;
    private List<Product> products;
    private String status;
    private Double totalCost;
    private OrderStatus orderStatus;
}
