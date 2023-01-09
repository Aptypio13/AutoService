package com.project.autoservice.repository;

import com.project.autoservice.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepository<T> extends JpaRepository<CarOwner, Long> {
}
