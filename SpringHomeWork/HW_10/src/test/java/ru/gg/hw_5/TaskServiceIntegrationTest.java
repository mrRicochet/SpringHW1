package ru.gg.hw_5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gg.hw_5.models.Task;
import ru.gg.hw_5.models.TaskStatus;
import ru.gg.hw_5.repositories.TaskRepository;
import ru.gg.hw_5.services.TaskService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TaskServiceIntegrationTest {
    @MockBean
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @Test
    public void updateTaskStatus() {
        Task task = new Task();
        task.setStatus(TaskStatus.NOT_STARTED);
        given(taskRepository.findById(1L)).willReturn(Optional.of(task));
        taskService.updateTaskStatus(1L);
        verify(taskRepository).save(any(Task.class));
    }

}
