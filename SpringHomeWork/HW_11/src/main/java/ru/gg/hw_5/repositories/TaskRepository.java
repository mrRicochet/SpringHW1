package ru.gg.hw_5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gg.hw_5.models.Task;
import ru.gg.hw_5.models.TaskStatus;


import java.util.List;

/**
 * Репозиторий для работы с БД H2
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    /**
     * Собственный метод получения списка задач по статусу
     *
     * @param status искомый статус
     * @return список задач
     */
    List<Task> findTasksByStatus(TaskStatus status);

}