package com.project.autoservice.service.impl;

import com.project.autoservice.model.CarOwner;
import com.project.autoservice.repository.CarOwnerRepository;
import com.project.autoservice.service.CarOwnerService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarOwnerServiceImpl implements CarOwnerService<CarOwner> {
    private final CarOwnerRepository<CarOwner> carOwnerRepository;

    @Override
    public CarOwner add(@NonNull CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Override
    public CarOwner getById(Long id) {
        return carOwnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such owner with id: " + id));
    }

    @Override
    public CarOwner update(Long id, CarOwner carOwnerUpdate) {
        CarOwner carOwner = getById(id);
        carOwner.setCars(carOwnerUpdate.getCars());
        carOwner.setOrders(carOwnerUpdate.getOrders());
        return carOwnerRepository.save(carOwner);
    }
}
