package com.mate.test.autoservice.dto.requestDto;

import java.time.LocalDate;
import java.util.List;
import com.mate.test.autoservice.model.TypeOfTask;
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
