package com.mate.test.autoservice.service;

import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.repository.ProductRepository;
import com.mate.test.autoservice.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository<Product> productRepository;
    private Product expected;

    @Test
    void whenAddProductCorrect_ThenOk() {
        expected = new Product();
        expected.setPrice(0.0);
        expected.setName("Test");
        Mockito.when(productRepository.save(expected))
                .thenReturn(expected);
        Product actual = productService.add(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenAddProductIncorrect_ThenException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> productService.add(null));
    }

    @Test
    void whenUpdateCorrect_ThenOk() {
        expected = new Product();
        expected.setName("TestName");
        expected.setPrice(1985.0);
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(new Product()));
        Mockito.when(productRepository.save(expected))
                .thenReturn(expected);
        Product actual = productService.update(1L, expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }
}
