package com.mate.test.autoservice.mapper.requestMapper;

import com.mate.test.autoservice.dto.requestDto.ProductRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Product;
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
