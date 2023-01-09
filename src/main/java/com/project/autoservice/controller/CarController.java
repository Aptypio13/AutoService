package com.project.autoservice.controller;

import com.project.autoservice.dto.request.CarRequestDto;
import com.project.autoservice.dto.response.CarResponseDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Car;
import com.project.autoservice.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private final CarService<Car> carService;
    private final RequestMapper<Car, CarRequestDto> requestMapper;
    private final ResponseMapper<Car, CarResponseDto> responseMapper;

    @PostMapping()
    @Operation(description = "save a car to DB")
    public CarResponseDto createCar(@RequestBody CarRequestDto car) {
        return responseMapper.toDto(carService.add(requestMapper.toModel(car)));
    }

    @PutMapping("/{id}")
    @Operation(description = "update a car")
    public CarResponseDto updateCar(@PathVariable Long id, @RequestBody CarRequestDto car) {
        return responseMapper.toDto(carService.update(id, requestMapper.toModel(car)));
    }
}
