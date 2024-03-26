package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class TasksServicesTest {
    private TasksService tasksService;
    private ArrayTaskList tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayTaskList();
        tasksService = new TasksService(tasks);
    }

    @Test
    void testGetObservableList() {
        Task task = new Task("Test", new Date());
        tasks.add(task);
        assertEquals(1, tasksService.getObservableList().size());
        assertEquals(task, tasksService.getObservableList().get(0));
    }

    @Test
    void testGetIntervalInHours() {
        Task task = new Task("Test", new Date());
        assertEquals("01:00", tasksService.getIntervalInHours(task));
    }
}