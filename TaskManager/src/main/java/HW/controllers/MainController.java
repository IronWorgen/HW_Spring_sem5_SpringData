package HW.controllers;

import HW.data.task.Task;
import HW.data.task.TaskStatus;
import HW.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("task")
public class MainController {
    private final TaskRepository taskRepository;


    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        task.setTimeOfCreation(LocalDateTime.now());
        taskRepository.save(task);
        return "добавлена задача:\t" + task;
    }


    @GetMapping("/")
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }


    @GetMapping("/{taskStatus}")
    public List<Task> findByStatus(@PathVariable TaskStatus taskStatus) {
        return taskRepository.findAllZadachiByStatus(taskStatus);
    }


    @PutMapping("/update/{id}")
    public Task updateTaskStatus(@PathVariable long id, @RequestBody Task task) {
        Task taskFromDB = taskRepository.findTaskById(id);
        taskFromDB.setStatus(task.getStatus());
        taskRepository.save(taskFromDB);
        return taskFromDB;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}
