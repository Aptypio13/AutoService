package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.MechanicRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Mechanic;
import org.springframework.stereotype.Component;

@Component
public class MasterRequestMapper implements RequestMapper<Mechanic, MechanicRequestDto> {
    @Override
    public Mechanic toModel(MechanicRequestDto dto) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFirstName(dto.getFirstName());
        mechanic.setOrders(dto.getOrders());
        mechanic.setLastName(dto.getLastName());
        mechanic.setMiddleName(dto.getMiddleName());
        return mechanic;
    }
}
