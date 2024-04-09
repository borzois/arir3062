package tasks.model.LinkedTaskListt;

import tasks.model.Task;
import tasks.model.LinkedTaskList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Date;

public class TestRemoveTask_Valid {
    @Test
    public void testRemoveValidTask() {
        LinkedTaskList tasklist = new LinkedTaskList();
        Date date = new Date();
        Task task = new Task("title", date);
        tasklist.add(task);
        assertTrue(tasklist.remove(task));
    }
}