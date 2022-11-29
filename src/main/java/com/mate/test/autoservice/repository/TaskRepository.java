package com.mate.test.autoservice.repository;

import com.mate.test.autoservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository<T> extends JpaRepository<Task, Long> {
}
