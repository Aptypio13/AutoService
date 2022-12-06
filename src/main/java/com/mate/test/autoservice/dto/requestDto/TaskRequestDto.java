package com.mate.test.autoservice.dto.requestDto;

import com.mate.test.autoservice.model.PaymentStatus;
import com.mate.test.autoservice.model.TypeOfTask;
import lombok.Data;
@Data
public class TaskRequestDto {
    private Long orderId;
    private Long mechanicId;
    private Double price;
    private PaymentStatus paymentStatus;
    private TypeOfTask typeOfTask;
}
