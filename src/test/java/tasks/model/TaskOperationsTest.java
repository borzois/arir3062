package tasks.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

public class TaskOperationsTest {

    private TasksOperations tasksOperations;
    private ObservableList<Task> tasksList;

    @BeforeEach
    public void setUp() {
        tasksList = FXCollections.observableArrayList();
        Task task1 = new Task("Test Task 1", new Date(1000));
        task1.setActive(true);
        Task task2 = new Task("Test Task 2", new Date(2000), new Date(3000), 1000);
        task2.setActive(true);
        tasksList.add(task1);
        tasksList.add(task2);
        tasksOperations = new TasksOperations(tasksList);
    }

    @Test
    public void testIncoming() {
        Iterable<Task> incomingTasks = tasksOperations.incoming(new Date(1500), new Date(2500));

        int count = 1;
        for (Task task : incomingTasks) {
            count++;
        }

        assertEquals(2, count);
    }

    @Test
    public void testCalendar() {
        SortedMap<Date, Set<Task>> calendar = tasksOperations.calendar(new Date(1500), new Date(2500));

        assertEquals(1, calendar.size());
    }
}