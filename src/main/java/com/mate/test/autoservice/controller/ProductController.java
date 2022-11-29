package com.mate.test.autoservice.controller;

import com.mate.test.autoservice.dto.requestDto.ProductRequestDto;
import com.mate.test.autoservice.mapper.RequestMapper;
import com.mate.test.autoservice.model.Product;
import com.mate.test.autoservice.service.ProductService;
import lombok.AllArgsConstructor;
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

    @PostMapping("/add")
    public void createProduct(@RequestBody ProductRequestDto product) {
        productService.add(requestMapper.toModel(product));
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductRequestDto product) {
        productService.add(requestMapper.toModel(product));
    }
}
