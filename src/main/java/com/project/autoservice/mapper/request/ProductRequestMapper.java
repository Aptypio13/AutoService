package com.project.autoservice.mapper.request;

import com.project.autoservice.dto.request.ProductRequestDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestMapper implements RequestMapper<Product, ProductRequestDto> {
    @Override
    public Product toModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }
}
