package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.model.OrderStatus;
import com.mate.test.autoservice.repository.MechanicRepository;
import com.mate.test.autoservice.service.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MechanicServiceImpl implements MechanicService<Mechanic> {
    private final static Double MECHANIC_COMMISSION = 0.4;
    private final MechanicRepository mechanicRepository;

    @Override
    public Mechanic add(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    @Override
    public List<Order> getOrdersByMechanicId(Long id) {
        return getById(id).getOrders();
    }

    @Override
    public Mechanic getById(Long id) {
        return mechanicRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("No such mechanic with id: " + id)
                );
    }

    @Override
    public Double getSalaryById(Long id) {
        List<Order> ordersByMechanicId = getOrdersByMechanicId(id);
        double sumOfOrders = ordersByMechanicId
                .stream()
                .filter(
                        o -> o.getOrderStatus() == OrderStatus.SUCCESSFUL_DONE)
                .mapToDouble(Order :: getTotalCost)
                .sum();
        return sumOfOrders * MECHANIC_COMMISSION;
    }

    @Override
    public Mechanic update(Long id, Mechanic mechanicUpdate) {
        Mechanic mechanic = getById(id);
        mechanic.setFirstName(mechanicUpdate.getFirstName());
        mechanic.setOrders(mechanicUpdate.getOrders());
        mechanic.setMiddleName(mechanicUpdate.getMiddleName());
        mechanic.setLastName(mechanicUpdate.getLastName());
        mechanicRepository.save(mechanic);
        return mechanic;
    }
}
