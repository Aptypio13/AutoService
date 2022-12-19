package com.mate.test.autoservice.dto.responseDto;

import com.mate.test.autoservice.model.PaymentStatus;
import com.mate.test.autoservice.model.TypeOfTask;
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
