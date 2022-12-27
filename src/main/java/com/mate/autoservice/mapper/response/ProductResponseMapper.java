package com.mate.autoservice.mapper.response;

import com.mate.autoservice.dto.response.ProductResponseDto;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Product;
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
