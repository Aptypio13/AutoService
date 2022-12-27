package com.mate.autoservice.dto.request;

import com.mate.autoservice.model.TypeOfTask;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Long carId;
    private String descriptionOfProblem;
    private LocalDate dateOfApplication;
    private LocalDate dateOfCompletion;
    private List<Long> tasksId;
    private List<Long> productsId;
    private TypeOfTask task;
}
