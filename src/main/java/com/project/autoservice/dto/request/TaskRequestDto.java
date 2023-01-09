package com.project.autoservice.dto.request;

import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.TypeOfTask;
import lombok.Data;

@Data
public class TaskRequestDto {
    private Long orderId;
    private Long mechanicId;
    private Double price;
    private PaymentStatus paymentStatus;
    private TypeOfTask typeOfTask;
}
