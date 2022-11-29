package com.mate.test.autoservice.dto.responseDto;

import java.util.List;
import java.time.LocalDate;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.model.Task;
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
