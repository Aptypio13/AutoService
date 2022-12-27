package com.mate.autoservice.dto.response;

import com.mate.autoservice.model.PaymentStatus;
import com.mate.autoservice.model.TypeOfTask;
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
