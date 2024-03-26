package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.model.ArrayTaskList;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTaskListTest {
    private ArrayTaskList taskList;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
    }

    @Test
    void testAdd() {
        Task task = new Task("Test", new Date());
        taskList.add(task);
        assertEquals(1, taskList.size());
        assertEquals(task, taskList.getTask(0));
    }

    @Test
    void testRemove() {
        Task task = new Task("Test", new Date());
        taskList.add(task);
        taskList.remove(task);
        assertEquals(0, taskList.size());
    }

    @Test
    void testSize() {
        Task task1 = new Task("Test1", new Date());
        Task task2 = new Task("Test2", new Date());
        taskList.add(task1);
        taskList.add(task2);
        assertEquals(2, taskList.size());
    }

    @Test
    void testGetTask() {
        Task task = new Task("Test", new Date());
        taskList.add(task);
        assertEquals(task, taskList.getTask(0));
    }
}