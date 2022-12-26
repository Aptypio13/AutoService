package com.mate.test.autoservice.repository;

import com.mate.test.autoservice.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository<T> extends JpaRepository<Mechanic, Long> {
}
