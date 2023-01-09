package com.project.autoservice.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class MechanicRequestDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private List<Long> finishedOrdersId;
}
