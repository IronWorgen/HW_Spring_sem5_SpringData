package HW.data.task.converters;

import HW.data.task.TaskStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    @Override
    public String convertToDatabaseColumn(TaskStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getStatus();
    }


    @Override
    public TaskStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Arrays.stream(TaskStatus.values())
                .filter(x -> x.getStatus().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
