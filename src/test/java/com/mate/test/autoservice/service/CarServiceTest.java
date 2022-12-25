package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.Car;
import com.mate.test.autoservice.model.CarOwner;
import com.mate.test.autoservice.repository.CarRepository;
import com.mate.test.autoservice.service.impl.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class CarServiceTest {
    @InjectMocks
    private CarServiceImpl carService;
    @Mock
    private CarRepository<Car> carRepository;
    private Car expected;

    @Test
    void whenAddCarCorrect_ThanOk() {
        expected = new Car();
        expected.setMark("Toyota");
        expected.setModel("Corolla");
        expected.setNumber("AX03413PI");
        expected.setYearOfManufacture(LocalDate.of(1998,2,14));
        expected.setOwner(new CarOwner());
        Mockito.when(carRepository.save(expected))
                .thenReturn(expected);
        Car actual = carService.add(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenAddCarWithNull_ThenException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> carService.add(null));
    }

    @Test
    void whenGetCarByIdCorrect_ThanOk() {
        expected = new Car();
        Mockito.when(carRepository.findById(1L))
                        .thenReturn(Optional.of(new Car()));
        Car actual = carService.getById(1L);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenGetCarByIdIncorrectInput_ThenException() {
        Assertions.assertThrows(RuntimeException.class,
                () -> carService.getById(Long.MAX_VALUE));
    }

    @Test
    void whenUpdateMethodCorrectInput_ThenOk() {
        expected = new Car();
        expected.setModel("expected");
        Mockito.when(carRepository.findById(1L))
                .thenReturn(Optional.of(new Car()));
        Mockito.when(carRepository.save(expected)).thenReturn(expected);
        Car actual = carService.update(1L, expected);
        Assertions.assertEquals(expected, actual);
    }
}
