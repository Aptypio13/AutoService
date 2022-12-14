package com.project.autoservice.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class MechanicResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Long> ordersId;
}
