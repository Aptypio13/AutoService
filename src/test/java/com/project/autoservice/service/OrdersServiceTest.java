package com.project.autoservice.service;

import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.Product;
import com.project.autoservice.model.Order;
import com.project.autoservice.model.Task;
import com.project.autoservice.repository.OrderRepository;
import com.project.autoservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrdersServiceTest {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private ProductService<Product> productService;
    @Mock
    private OrderRepository<Order> orderRepository;
    private Order expected;

    @Test
    void whenGetAllByOwnerIdCorrect_ThanOk() {
        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(new Order());
        expectedOrders.add(new Order());
        expectedOrders.add(new Order());
        Mockito
                .when(orderRepository.findAllByCarOwnerId(1L))
                .thenReturn(expectedOrders);
        List<Order> actual = orderService.getAllByOwnerId(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedOrders.size(), actual.size());
    }

    @Test
    void whenGetTotalCostByIdCorrect_ThanOk() {
        Order testOrder = Mockito.mock(Order.class, Answers.RETURNS_DEEP_STUBS);
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        Task task = new Task();
        task.setPrice(56.0);
        task.setPaymentStatus(PaymentStatus.NOT_PAID);
        List<Product> products = List.of(product);
        List<Task> tasks = List.of(task);
        Mockito
                .when(orderRepository.findById(1L))
                .thenReturn(Optional.of(testOrder));
        Mockito
                .when(testOrder.getCar().getOwner().getOrders().size())
                .thenReturn(1);
        Mockito
                .when(testOrder.getProducts())
                .thenReturn(products);
        Mockito
                .when(testOrder.getTasks())
                .thenReturn(tasks);
        Double actual = orderService.getTotalCostById(1L);
        Double expectedTotalCost = 155.7;
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expectedTotalCost, actual);
    }

    @Test
    void whenAddOrderCorrect_ThanOk() {
        expected = new Order();
        Mockito
                .when(orderRepository.save(expected))
                .thenReturn(expected);
        Order actual = orderService.add(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenAddProductToOrderCorrect_ThanOk() {
        expected = new Order();
        expected.setProducts(new ArrayList<>());
        Mockito.when(orderRepository.findById(1L))
                .thenReturn(Optional.ofNullable(expected));
        Mockito.when(productService.getById(1L))
                .thenReturn(new Product());
        Mockito.when(orderRepository.save(expected))
                .thenReturn(expected);
        Order actual = orderService.addProduct(1L, 1L);
        Assertions.assertNotNull(actual);
        Assertions.assertDoesNotThrow(actual :: getProducts);
        Assertions.assertEquals(1, actual.getProducts().size());
    }

    @Test
    void whenAddProductIncorrect_ThenException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> orderService.add(null));
    }
}
