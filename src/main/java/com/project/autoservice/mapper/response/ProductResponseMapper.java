package com.project.autoservice.mapper.response;

import com.project.autoservice.dto.response.ProductResponseDto;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Product;
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
