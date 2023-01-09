package com.project.autoservice.dto.response;

import com.project.autoservice.model.Car;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.model.Product;
import com.project.autoservice.model.Task;
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
    private List<Long> tasksId;
    private List<Long> productsId;
    private String status;
    private Double totalCost;
    private OrderStatus orderStatus;
}
