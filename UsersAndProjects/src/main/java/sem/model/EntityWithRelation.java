package sem.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Создайте абстрактный класс "сущность с связью" (EntityWithRelation), который будет содержать следующие поля:
 * <p>
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Идентификатор связанной сущности (relatedEntityId) типа Long
 */
@MappedSuperclass
public abstract class EntityWithRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * не понял, зачем нужно это поле в тз?
     */
    private Long relatedEntityId;

}
