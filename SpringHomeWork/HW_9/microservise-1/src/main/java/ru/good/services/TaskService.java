package ru.good.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.good.models.Task;
import ru.good.models.TaskStatus;
import ru.good.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    /**
     * Получение списка задач
     * @return
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Сохранение задачи
     * @param task
     * @return
     */
    private Task saveTask(Task task) {
        return repository.save(task);
    }

    /**
     * Создание задачи
     * @param description
     * @return
     */

    public Task createTask(String description) {
        Task newTask = new Task();
        newTask.setDescription(description);
        newTask.setStatus(TaskStatus.NOT_STARTED);
        newTask.setDateCreate(LocalDateTime.now());
        return saveTask(newTask);
    }

    /**
     * Метод изменения статуса задачи
     *
     * @param
     * @return
     */
    public Task updateTaskStatus(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (task.getStatus().equals(TaskStatus.NOT_STARTED)) {
                task.setStatus(TaskStatus.IN_PROGRESS);
            } else if (task.getStatus().equals(TaskStatus.IN_PROGRESS)) {
                task.setStatus(TaskStatus.COMPLETED);
            }
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }


    /**
     * Метод поиска списка задач по статусу
     *
     * @param
     * @return
     */
    public List<Task> findTaskByStatus(TaskStatus status) {
        return repository.findTasksByStatus(status);
    }

    /**
     * Метод удаления задачи по id
     *
     * @param
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
