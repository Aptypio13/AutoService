package com.mate.autoservice.dto.request;

import com.mate.autoservice.model.PaymentStatus;
import com.mate.autoservice.model.TypeOfTask;
import lombok.Data;

@Data
public class TaskRequestDto {
    private Long orderId;
    private Long mechanicId;
    private Double price;
    private PaymentStatus paymentStatus;
    private TypeOfTask typeOfTask;
}
