package com.project.autoservice.service;

import com.project.autoservice.model.CarOwner;
import com.project.autoservice.repository.CarOwnerRepository;
import com.project.autoservice.service.impl.CarOwnerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CarOwnerServiceTest {
    @InjectMocks
    private CarOwnerServiceImpl carOwnerService;
    @Mock
    private CarOwnerRepository<CarOwner> carOwnerRepository;
    private CarOwner expected;

    @Test
    void whenAddCarOwnerCorrect_ThanOk() {
        expected = new CarOwner();
        Mockito
                .when(carOwnerRepository.save(expected))
                .thenReturn(expected);
        CarOwner actual = carOwnerService.add(new CarOwner());
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void whenAddCarOwnerIncorrect_ThanException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> carOwnerService.add(null));
    }

    @Test
    void whenGetCarOwnerIncorrect_ThanException() {
        Assertions.assertThrows(RuntimeException.class,
                () -> carOwnerService.getById(Long.MAX_VALUE));
    }

    @Test
    void whenUpdateCorrect_ThanOk() {
        expected = new CarOwner();
        expected.setOrders(List.of());
        expected.setCars(List.of());
        Mockito
                .when(carOwnerRepository.findById(1L))
                .thenReturn(Optional.of(new CarOwner()));
        Mockito
                .when(carOwnerRepository.save(expected))
                .thenReturn(expected);
        CarOwner actual = carOwnerService.update(1L, expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }
}
