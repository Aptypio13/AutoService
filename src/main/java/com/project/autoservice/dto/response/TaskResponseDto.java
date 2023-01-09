package com.project.autoservice.dto.response;

import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.TypeOfTask;
import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private Long orderId;
    private Long mechanicId;
    private Double price;
    private PaymentStatus paymentStatus;
    private TypeOfTask typeOfTask;

}
