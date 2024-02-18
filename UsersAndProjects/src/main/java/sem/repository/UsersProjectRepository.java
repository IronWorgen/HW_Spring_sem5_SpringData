package sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sem.model.UsersProject;

import java.util.List;


/**
 * Создайте интерфейс репозитория (UsersProjectRepository), который будет расширять JpaRepository<UsersProject, Long>.
 */
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    /**
     * найти список пользователей, связанных с определенным проектом
     *
     * @param projectId id проекта
     * @return список id пользователей, участвующих в этом проекте
     */
    @Query("select userId from UsersProject where projectId=:projectId")
    List<Long> findAllUserIdByProjectId(Long projectId);


    /**
     * возвращающий список проектов, связанных с определенным пользователем
     *
     * @param userId id пользователя
     * @return список id проектов, в которых участвует пользователь
     */
    @Query("select projectId from UsersProject where userId=:userId")
    List<Long> findAllProjectIdByUserId(Long userId);


    /**
     * поиск UsersProject по пользователю и проекту
     *
     * @param userId    id пользователя
     * @param projectId id проекта
     * @return UsersProject
     */
    UsersProject findByUserIdAndProjectId(Long userId, Long projectId);
}
