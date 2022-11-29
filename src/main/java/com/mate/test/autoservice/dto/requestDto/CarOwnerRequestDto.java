package com.mate.test.autoservice.dto.requestDto;

import java.util.List;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.Order;
import lombok.Data;

@Data
public class CarOwnerRequestDto {
    private List<Car> cars;
    private List<Order> orders;
}
