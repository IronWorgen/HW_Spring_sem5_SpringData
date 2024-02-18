package HW.data.task;

import HW.data.task.converters.LocalDateTimeSqlConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    private TaskStatus status = TaskStatus.NOT_STARTED;
    @Column(columnDefinition = "TIMESTAMP")
    @Convert(converter = LocalDateTimeSqlConverter.class)
    private LocalDateTime timeOfCreation;
}
