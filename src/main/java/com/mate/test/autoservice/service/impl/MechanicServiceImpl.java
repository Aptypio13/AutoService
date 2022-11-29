package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Mechanic;
import com.mate.test.autoservice.model.Order;
import com.mate.test.autoservice.repository.MechanicRepository;
import com.mate.test.autoservice.service.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MechanicServiceImpl implements MechanicService<Mechanic> {
    private final double mechanicCommission = 0.4;
    private final MechanicRepository mechanicRepository;

    @Override
    public void add(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    @Override
    public List<Mechanic> getAll() {
        return mechanicRepository.findAll();
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
        double sumOfOrders = ordersByMechanicId.stream().mapToDouble(Order :: getTotalCost).sum();
        return sumOfOrders * mechanicCommission;
    }
}
