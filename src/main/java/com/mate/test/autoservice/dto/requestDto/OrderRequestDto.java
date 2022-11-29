package com.mate.test.autoservice.dto.requestDto;

import java.time.LocalDate;
import java.util.List;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.model.Task;
import com.mate.test.autoservice.model.TypeOfTask;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Car car;
    private String descriptionOfProblem;
    private LocalDate dateOfApplication;
    private LocalDate dateOfCompletion;
    private List<Task> tasks;
    private List<Product> products;
    private TypeOfTask task;
    private Double totalCost;
    private OrderStatus orderStatus;
}
