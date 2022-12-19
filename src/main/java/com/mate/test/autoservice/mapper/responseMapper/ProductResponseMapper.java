package com.mate.test.autoservice.mapper.responseMapper;

import com.mate.test.autoservice.dto.responseDto.ProductResponseDto;
import com.mate.test.autoservice.mapper.ResponseMapper;
import com.mate.test.autoservice.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper implements ResponseMapper<Product, ProductResponseDto> {
    @Override
    public ProductResponseDto toDto(Product model) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(model.getName());
        productResponseDto.setPrice(model.getPrice());
        productResponseDto.setId(model.getId());
        return productResponseDto;
    }
}
