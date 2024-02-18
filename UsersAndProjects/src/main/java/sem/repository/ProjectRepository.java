package sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem.model.Project;

import java.util.List;


/**
 * Создайте интерфейс репозитория (ProjectRepository), который будет расширять JpaRepository<Project, Long>.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectByIdIn(List<Long> projectIdList);
}
