package com.project.autoservice.mapper.response;

import com.project.autoservice.dto.response.MechanicResponseDto;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MasterResponseMapper implements ResponseMapper<Mechanic, MechanicResponseDto> {
    @Override
    public MechanicResponseDto toDto(Mechanic model) {
        MechanicResponseDto dto = new MechanicResponseDto();
        dto.setFirstName(model.getFirstName());
        dto.setId(model.getId());
        dto.setLastName(model.getLastName());
        dto.setMiddleName(model.getMiddleName());
        dto.setOrdersId(model.getOrders().stream().map(Order ::getId).collect(Collectors.toList()));
        return dto;
    }
}
