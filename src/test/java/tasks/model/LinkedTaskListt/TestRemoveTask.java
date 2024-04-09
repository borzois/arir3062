package tasks.model.LinkedTaskListt;

import tasks.model.LinkedTaskList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRemoveTask {
    @Test
    public void testRemoveNullTask() {
        LinkedTaskList tasklist = new LinkedTaskList();
        assertThrows(NullPointerException.class, () -> {
            tasklist.remove(null);
        });
    }
}