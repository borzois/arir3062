package tasks.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
/*
public class ControllerTest {
    private Controller controller;
    private ObservableList<Task> tasks;
    private TasksService service;


    @BeforeEach
    void setUp() {
        tasks = FXCollections.observableArrayList();
        service = new TasksService((ArrayTaskList) tasks);
        controller = new Controller();
        controller.setService(service);
    }

    @Test
    void testSetService() {
        assertDoesNotThrow(() -> controller.setService(service));
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("Test", new Date());
        tasks.add(task);
        assertDoesNotThrow(() -> controller.deleteTask());
    }

    @Test
    void testShowFilteredTasks() {
        assertDoesNotThrow(() -> controller.showFilteredTasks());
    }

    @Test
    void testResetFilteredTasks() {
        assertDoesNotThrow(() -> controller.resetFilteredTasks());
    }
}*/