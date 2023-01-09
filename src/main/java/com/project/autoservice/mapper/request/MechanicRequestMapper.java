package com.project.autoservice.mapper.request;

import com.project.autoservice.dto.request.MechanicRequestDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import com.project.autoservice.service.OrderService;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MechanicRequestMapper implements RequestMapper<Mechanic, MechanicRequestDto> {
    private final OrderService<Order> orderService;

    @Override
    public Mechanic toModel(MechanicRequestDto dto) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFirstName(dto.getFirstName());
        mechanic.setOrders(dto.getFinishedOrdersId()
                .stream()
                .map(orderService:: getById)
                .collect(Collectors.toList()));
        mechanic.setLastName(dto.getLastName());
        mechanic.setMiddleName(dto.getMiddleName());
        return mechanic;
    }
}
