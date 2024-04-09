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
        // Test case 1
        Task task1 = new Task("Task", new Date(10), new Date(15), 2);
        taskList.add(task1);
        assertEquals(1, taskList.size());
        assertEquals(task1, taskList.getTask(0));
        System.out.println("Test case 1 passed");

        // Test case 2
        assertThrows(IllegalArgumentException.class, () -> {
            Task task2 = new Task("Task", new Date(-1), new Date(15), 2);
            taskList.add(task2);
        });
        System.out.println("Test case 2 passed");

        // Test case 3
        assertThrows(IllegalArgumentException.class, () -> {
            Task task3 = new Task("Task", new Date(10), new Date(-1), 2);
            taskList.add(task3);
        });
        System.out.println("Test case 3 passed");

        // Test case 4
        assertThrows(IllegalArgumentException.class, () -> {
            Task task4 = new Task("Task", new Date(-1), new Date(-1), 2);
            taskList.add(task4);
        });
        System.out.println("Test case 4 passed");

        // Test case 5
        Task task5 = new Task("Task", new Date(1), new Date(15), 2);
        taskList.add(task5);
        assertEquals(2, taskList.size());
        assertEquals(task5, taskList.getTask(1));
        System.out.println("Test case 5 passed");

        // Test case 6
        assertThrows(IllegalArgumentException.class, () -> {
            Task task6 = new Task("Task", new Date(-1), new Date(15), 2);
            taskList.add(task6);
        });
        System.out.println("Test case 6 passed");

        // Test case 7
        Task task7 = new Task("Task", new Date(15), new Date(1), 2);
        taskList.add(task7);
        assertEquals(3, taskList.size());
        assertEquals(task7, taskList.getTask(2));
        System.out.println("Test case 7 passed");

        // Test case 8
        assertThrows(IllegalArgumentException.class, () -> {
            Task task8 = new Task("Task", new Date(15), new Date(-1), 2);
            taskList.add(task8);
        });
        System.out.println("Test case 8 passed");
    }
}