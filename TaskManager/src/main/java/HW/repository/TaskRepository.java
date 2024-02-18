package HW.repository;

import HW.data.task.Task;
import HW.data.task.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findTaskById(Long id);

    List<Task> findAllZadachiByStatus(TaskStatus taskStatus);
}
