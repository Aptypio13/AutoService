package com.mate.autoservice.repository;

import com.mate.autoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T> extends JpaRepository<Product, Long> {
}
