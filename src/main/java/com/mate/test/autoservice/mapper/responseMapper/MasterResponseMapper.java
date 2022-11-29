package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.MechanicResponseDto;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Mechanic;
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
