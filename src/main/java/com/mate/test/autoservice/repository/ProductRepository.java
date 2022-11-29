package com.mate.test.autoservice.repository;

import com.mate.test.autoservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository<T> extends JpaRepository<Product, Long> {
}
