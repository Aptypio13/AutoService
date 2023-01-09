package com.project.autoservice.service;

import com.project.autoservice.model.Mechanic;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.OrderStatus;
import com.project.autoservice.repository.MechanicRepository;
import com.project.autoservice.service.impl.MechanicServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MechanicServiceTest {
    @InjectMocks
    private MechanicServiceImpl mechanicService;
    @Mock
    private MechanicRepository<Mechanic> mechanicRepository;
    private Mechanic expected;

    @Test
    void whenAddMechanicCorrect_ThenOk() {
        expected = new Mechanic();
        Mockito
                .when(mechanicRepository.save(expected))
                .thenReturn(expected);
        Mechanic actual = mechanicService.add(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void whenAddMechanicIncorrect_ThenException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> mechanicService.add(null));
    }
    @Test
    void whenGetMechanicIncorrect_ThenException() {
        Assertions.assertThrows(RuntimeException.class,
                () -> mechanicService.getById(Long.MAX_VALUE));
    }

    @Test
    void whenUpdateMechanicCorrect_ThenOk() {
        expected = new Mechanic();
        expected.setFirstName("Test");
        expected.setLastName("Test");
        expected.setOrders(List.of());
        expected.setMiddleName("Test");
        Mockito
                .when(mechanicRepository.save(expected))
                .thenReturn(expected);
        Mockito.when(mechanicRepository.findById(1L))
                .thenReturn(Optional.of(new Mechanic()));
        Mechanic actual = mechanicService.update(1L,expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void whenGetOrdersByMechanicIdCorrect_ThenOk() {
        expected = new Mechanic();
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order());
        orderList.add(new Order());
        orderList.add(new Order());
        expected.setOrders(orderList);
        Mockito
                .when(mechanicRepository.findById(1L))
                .thenReturn(Optional.ofNullable(expected));
        List<Order> actual = mechanicService.getOrdersByMechanicId(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getOrders().size(), actual.size());
    }

    @Test
    void whenGetSalaryByIdCorrect_ThenOk() {
        Mechanic mechanic = Mockito.mock(Mechanic.class, Mockito.RETURNS_DEEP_STUBS);
        Double expected = 100D * MechanicServiceImpl.MECHANIC_COMMISSION;
        Order mockOrder = new Order();
        mockOrder.setOrderStatus(OrderStatus.SUCCESSFUL_DONE);
        mockOrder.setTotalCost(100D);
        Mockito.when(mechanicRepository.findById(1L))
                        .thenReturn(Optional.ofNullable(mechanic));
        Mockito
                .when(mechanic.getOrders())
                .thenReturn(List.of(mockOrder));
        Double actual = mechanicService.getSalaryById(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }
}
