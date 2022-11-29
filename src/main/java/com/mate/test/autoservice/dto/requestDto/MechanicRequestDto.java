package com.mate.test.autoservice.dto.requestDto;

import java.util.List;
import com.mate.test.autoservice.model.Order;
import lombok.Data;

@Data
public class MechanicRequestDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Order> orders;
}
