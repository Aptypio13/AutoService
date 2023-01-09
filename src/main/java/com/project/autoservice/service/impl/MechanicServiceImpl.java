package com.project.autoservice.service.impl;

import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.repository.MechanicRepository;
import com.project.autoservice.service.MechanicService;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MechanicServiceImpl implements MechanicService<Mechanic> {
    private static final Double MECHANIC_COMMISSION = 0.4;
    private final MechanicRepository<Mechanic> mechanicRepository;

    @Override
    public Mechanic add(@NonNull Mechanic mechanic) {
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
                .mapToDouble(Order::getTotalCost)
                .sum();
        return sumOfOrders * MECHANIC_COMMISSION;
    }

    @Override
    public Mechanic update(@NonNull Long id, @NonNull Mechanic mechanicUpdate) {
        Mechanic mechanic = getById(id);
        mechanic.setFirstName(mechanicUpdate.getFirstName());
        mechanic.setOrders(mechanicUpdate.getOrders());
        mechanic.setMiddleName(mechanicUpdate.getMiddleName());
        mechanic.setLastName(mechanicUpdate.getLastName());
        mechanicRepository.save(mechanic);
        return mechanic;
    }
}
