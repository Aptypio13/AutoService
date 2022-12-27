package com.mate.autoservice.repository;

import com.mate.autoservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository<T> extends JpaRepository<Task, Long> {
}