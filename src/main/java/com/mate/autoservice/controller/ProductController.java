package com.mate.autoservice.controller;

import com.mate.autoservice.dto.request.ProductRequestDto;
import com.mate.autoservice.dto.response.ProductResponseDto;
import com.mate.autoservice.mapper.RequestMapper;
import com.mate.autoservice.mapper.ResponseMapper;
import com.mate.autoservice.model.Product;
import com.mate.autoservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService<Product> productService;
    private final RequestMapper<Product, ProductRequestDto> requestMapper;
    private final ResponseMapper<Product, ProductResponseDto> responseMapper;

    @PostMapping()
    @Operation(description = "save product to DB")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto product) {
        return responseMapper.toDto(productService.add(requestMapper.toModel(product)));
    }

    @PutMapping("/{id}")
    @Operation(description = "update product information")
    public ProductResponseDto updateProduct(
            @PathVariable Long id, @RequestBody ProductRequestDto product) {
        return responseMapper.toDto(productService.update(id, requestMapper.toModel(product)));
    }
}
