package com.project.autoservice.controller;

import com.project.autoservice.dto.request.ProductRequestDto;
import com.project.autoservice.dto.response.ProductResponseDto;
import com.project.autoservice.mapper.RequestMapper;
import com.project.autoservice.mapper.ResponseMapper;
import com.project.autoservice.model.Product;
import com.project.autoservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
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
