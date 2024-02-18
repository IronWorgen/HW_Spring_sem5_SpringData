package sem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Создайте сущность "пользователи проекта" (UsersProject), которая наследуется от класса "сущность с связью" и будет содержать следующие поля:
 *
 * Идентификатор проекта (projectId) типа Long
 * Идентификатор пользователя (userId) типа Long
 */
@Entity
@Table(name = "user_project")
@NoArgsConstructor
public class UsersProject extends EntityWithRelation{

    private Long userId;
    private  Long projectId;

    public UsersProject(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}
