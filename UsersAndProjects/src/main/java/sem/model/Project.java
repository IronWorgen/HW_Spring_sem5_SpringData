package sem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


/**
 * Создайте сущность "проект" (Project), которая будет содержать следующие поля:
 *
 * Идентификатор (id) типа Long, генерируемый автоматически при создании записи
 * Название проекта (name) типа String
 * Описание проекта (description) типа String
 * Дата создания (createdDate) типа LocalDate
 * Создайте абстрактный класс "сущность с связью" (EntityWithRelation), который будет содержать следующие поля:
 */
@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private  String description;
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;
}
