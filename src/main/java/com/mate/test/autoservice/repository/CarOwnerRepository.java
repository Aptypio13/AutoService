package com.mate.test.autoservice.repository;

import com.mate.test.autoservice.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepository<T> extends JpaRepository<CarOwner, Long> {
}
