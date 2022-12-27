package com.mate.autoservice.service.impl;

import com.mate.autoservice.model.Mechanic;
import com.mate.autoservice.model.Order;
import com.mate.autoservice.model.OrderStatus;
import com.mate.autoservice.repository.MechanicRepository;
import com.mate.autoservice.service.MechanicService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MechanicServiceImpl implements MechanicService<Mechanic> {
    private final Double mechanicCommission = 0.4;
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
        return sumOfOrders * mechanicCommission;
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