package sem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sem.model.User;

import java.util.List;


/**
 * Создайте интерфейс репозитория (UserRepository), который будет расширять JpaRepository<User, Long>.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByIdIn(List<Long> userIdList);
}
