package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.CarRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
    private final CarService<Car> carService;
    private final RequestMapper<Car, CarRequestDto> requestMapper;

    @PostMapping("/add")
    public void createCar(@RequestBody CarRequestDto car) {
        carService.add(requestMapper.toModel(car));
    }


    @PutMapping("/update")
    public void updateCar(@RequestBody CarRequestDto car) {
        carService.add(requestMapper.toModel(car));
    }
}
