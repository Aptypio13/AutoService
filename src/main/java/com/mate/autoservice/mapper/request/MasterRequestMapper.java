package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.MechanicRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Mechanic;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.service.OrderService;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
                .map(orderService:: getById)
                .collect(Collectors.toList()));
        mechanic.setLastName(dto.getLastName());
        mechanic.setMiddleName(dto.getMiddleName());
        return mechanic;
    }
}
