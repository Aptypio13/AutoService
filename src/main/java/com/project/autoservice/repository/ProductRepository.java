package com.project.autoservice.repository;

import com.project.autoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T> extends JpaRepository<Product, Long> {
}
