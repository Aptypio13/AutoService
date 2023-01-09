package com.project.autoservice.repository;

import com.project.autoservice.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository<T> extends JpaRepository<Order, Long> {
    List<Order> findAllByCarOwnerId(Long id);
}
