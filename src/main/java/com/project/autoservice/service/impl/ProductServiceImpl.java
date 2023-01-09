package com.project.autoservice.service.impl;

import com.project.autoservice.model.Product;
import com.project.autoservice.repository.ProductRepository;
import com.project.autoservice.service.ProductService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService<Product> {
    private final ProductRepository<Product> productRepository;

    public ProductServiceImpl(ProductRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(@NonNull Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such product with id: " + id));
    }

    @Override
    public Product update(Long id, Product entity) {
        Product product = getById(id);
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        return productRepository.save(product);
    }
}
