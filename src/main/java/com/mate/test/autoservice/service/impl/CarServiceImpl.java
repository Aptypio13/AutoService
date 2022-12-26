package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.repository.CarRepository;
import com.mate.test.autoservice.service.CarService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService<Car> {
    private final CarRepository<Car> carRepository;
    @Override
    public Car add(@NonNull Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such car with id: " + id));
    }

    @Override
    public Car update(@NonNull Long id, @NonNull Car entity) {
        Car carById = getById(id);
        carById.setMark(entity.getMark());
        carById.setOwner(entity.getOwner());
        carById.setNumber(entity.getNumber());
        carById.setModel(entity.getModel());
        carById.setYearOfManufacture(entity.getYearOfManufacture());
        carRepository.save(carById);
        return carById;
    }
}
