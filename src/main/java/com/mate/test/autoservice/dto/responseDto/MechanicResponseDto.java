package com.mate.test.autoservice.dto.responseDto;

import com.mate.test.autoservice.model.Order;
import java.util.List;
import lombok.Data;

@Data
public class MechanicResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Order> orders;
}
