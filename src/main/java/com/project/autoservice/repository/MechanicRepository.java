package com.project.autoservice.repository;

import com.project.autoservice.model.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicRepository<T> extends JpaRepository<Mechanic, Long> {
}
