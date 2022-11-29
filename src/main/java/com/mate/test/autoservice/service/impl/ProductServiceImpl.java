package com.mate.test.autoservice.service.impl;

import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.repository.ProductRepository;
import com.mate.test.autoservice.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService<Product> {
    private final ProductRepository<Product> productRepository;

    public ProductServiceImpl(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }
}
