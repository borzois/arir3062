package tasks.model.WithMockito;

import org.junit.jupiter.api.Test;
import tasks.model.Task;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTested {

    @Test
    void testSetTitle() throws ParseException {
        Task task = new Task("Test", Task.getDateFormat().parse("2023-02-12 10:10"));
        task.setTitle("New Title");
        assertEquals("New Title", task.getTitle());
    }

    @Test
    void testSetTime() throws ParseException {
        Task task = new Task("Test", Task.getDateFormat().parse("2023-02-12 10:10"));
        Date newTime = Task.getDateFormat().parse("2023-02-13 10:10");
        task.setTime(newTime);
        assertEquals(newTime, task.getTime());
    }

    @Test
    void testSetActive() throws ParseException {
        Task task = new Task("Test", Task.getDateFormat().parse("2023-02-12 10:10"));
        task.setActive(true);
        assertTrue(task.isActive());
    }
}