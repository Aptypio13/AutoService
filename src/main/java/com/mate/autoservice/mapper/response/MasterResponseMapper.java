package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.MechanicResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Mechanic;
import org.springframework.stereotype.Component;

@Component
public class MasterResponseMapper implements ResponseMapper<Mechanic, MechanicResponseDto> {
    @Override
    public MechanicResponseDto toDto(Mechanic model) {
        MechanicResponseDto dto = new MechanicResponseDto();
        dto.setFirstName(model.getFirstName());
        dto.setId(model.getId());
        dto.setLastName(model.getLastName());
        dto.setMiddleName(model.getMiddleName());
        return dto;
    }
}
