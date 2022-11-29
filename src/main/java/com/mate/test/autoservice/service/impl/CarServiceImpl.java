package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.repository.CarRepository;
import com.mate.test.autoservice.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService<Car> {
    private final CarRepository<Car> carCarRepository;

    @Override
    public void add(Car car) {
        carCarRepository.save(car);
    }
}
