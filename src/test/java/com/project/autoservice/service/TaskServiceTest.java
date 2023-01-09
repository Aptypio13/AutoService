package com.project.autoservice.service;

import com.project.autoservice.model.PaymentStatus;
import com.project.autoservice.model.Task;
import com.project.autoservice.repository.TaskRepository;
import com.project.autoservice.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TaskServiceTest {
    @InjectMocks
    private TaskServiceImpl taskService;
    @Mock
    private TaskRepository<Task> taskRepository;
    private Task expected;

    @Test
    void whenAddTaskCorrect_ThenOk() {
        expected = new Task();
        Mockito.when(taskRepository.save(expected))
                .thenReturn(expected);
        Task actual = taskService.add(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenUpdateTaskCorrect_ThenOk() {
        expected = new Task();
        expected.setPaymentStatus(PaymentStatus.PAID);
        Mockito.when(taskRepository.save(expected))
                .thenReturn(expected);
        Mockito.when(taskRepository.findById(1L))
                .thenReturn(Optional.of(expected));
        Task actual = taskService.updateTaskStatus(1L, PaymentStatus.PAID);
        Assertions.assertEquals(PaymentStatus.PAID, actual.getPaymentStatus());
    }
}
