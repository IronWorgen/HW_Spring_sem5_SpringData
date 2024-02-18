package HW.data.task;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum TaskStatus {
    NOT_STARTED("не начата"),
    IN_PROGRESS("в процессе"),
    COMPLETED("завершена");
    private String status;

    TaskStatus(String status) {
        this.status = status;
    }
}
