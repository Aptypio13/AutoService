package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.MechanicRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.service.MechanicService;
import com.mate.test.autoservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MasterRequestMapper implements RequestMapper<Mechanic, MechanicRequestDto> {
    private final OrderService<Order> orderService;
    @Override
    public Mechanic toModel(MechanicRequestDto dto) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFirstName(dto.getFirstName());
        mechanic.setOrders(dto.getFinishedOrdersId()
                .stream()
                .map(orderService::getOrderById)
                .collect(Collectors.toList()));
        mechanic.setLastName(dto.getLastName());
        mechanic.setMiddleName(dto.getMiddleName());
        return mechanic;
    }
}
