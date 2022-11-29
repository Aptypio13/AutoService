package com.mate.test.autoservice.dto.requestDto;

import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.PaymentStatus;
import com.mate.test.autoservice.model.TypeOfTask;
import lombok.Data;
@Data
public class TaskRequestDto {
    private Order order;
    private Mechanic mechanic;
    private Double price;
    private PaymentStatus paymentStatus;
    private TypeOfTask typeOfTask;
}
