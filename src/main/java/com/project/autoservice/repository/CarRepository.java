package com.project.autoservice.repository;

import com.project.autoservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository<T> extends JpaRepository<Car, Long> {
}
