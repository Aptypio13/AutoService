package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.repository.CarOwnerRepository;
import com.mate.test.autoservice.service.CarOwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarOwnerServiceImpl implements CarOwnerService<CarOwner> {
    private final CarOwnerRepository<CarOwner> carOwnerRepository;

    @Override
    public void add(CarOwner carOwner) {
        carOwnerRepository.save(carOwner);
    }
}
