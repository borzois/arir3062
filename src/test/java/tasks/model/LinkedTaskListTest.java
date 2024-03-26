package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedTaskListTest {

    private LinkedTaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new LinkedTaskList();
    }

    @Test
    public void testAdd() {
        Date date = new Date();
        Task task = new Task("Test Task", date);
        taskList.add(task);

        assertEquals(1, taskList.size());
        assertEquals(task, taskList.getTask(0));
    }

    @Test
    public void testRemove() {
        Date date = new Date();
        Task task = new Task("Test Task", date);
        taskList.add(task);
        taskList.remove(task);

        assertEquals(0, taskList.size());
    }

    @Test
    public void testSize() {
        Date date1 = new Date();
        Date date2 = new Date();
        Task task1 = new Task("Test Task 1", date1);
        Task task2 = new Task("Test Task 2", date2);
        taskList.add(task1);
        taskList.add(task2);

        assertEquals(2, taskList.size());
    }

    @Test
    public void testGetTask() {
        Date date = new Date();
        Task task = new Task("Test Task", date);
        taskList.add(task);

        assertEquals(task, taskList.getTask(0));
    }
}