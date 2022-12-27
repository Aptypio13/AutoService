package com.mate.autoservice.mapper.request;

import com.mate.autoservice.dto.request.ProductRequestDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.model.Product;
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
