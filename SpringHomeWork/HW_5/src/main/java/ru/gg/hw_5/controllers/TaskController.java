package ru.gg.hw_5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gg.hw_5.models.TaskStatus;
import ru.gg.hw_5.services.TaskService;
import ru.gg.hw_5.models.Task;


import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    /**
     * Метод обработки GET запроса без параметров
     * //localhost:8080/tasks
     *
     * @return
     */
    @GetMapping()
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    /**
     * POST метод обработки запроса добавления задачи через параметр
     * //localhost:8080/tasks/param?description=
     *
     * @param description тело задачи, передается через параметр
     * @return
     */
    @PostMapping()
    @RequestMapping("/param")
    public Task addTaskFromParam(@RequestParam("description") String description) {
        return taskService.createTask(description);
    }

    /**
     * GET метод обработки запроса списка задач с указанным статусом
     * //localhost:8080/tasks/status/(NOT_STARTED, IN_PROGRESS, COMPLETED)
     *
     * @param
     * @return
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findTaskByStatus(status);
    }

    /**
     * PUT метод обработки запроса изменения статуса задачи по id
     * //localhost:8080/tasks/{id}
     *
     * @param
     * @return
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        return taskService.updateTaskStatus(id);
    }

    /**
     * DELETE метод обработки запроса удаления задачи по id
     * //localhost:8080/tasks/{id}
     *
     * @param
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}