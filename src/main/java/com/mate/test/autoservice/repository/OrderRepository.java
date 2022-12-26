package com.mate.test.autoservice.repository;

import java.util.List;
import com.mate.test.autoservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository<T> extends JpaRepository<Order, Long> {
    List<Order> findAllByCar_OwnerId(Long id);
}
