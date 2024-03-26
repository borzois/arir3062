/*package tasks.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.controller.Notificator;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NotificatorTest {
    private Notificator notificator;
    private ObservableList<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = FXCollections.observableArrayList();
        notificator = new Notificator(tasks);
    }

    @Test
    void testRun() {
        assertDoesNotThrow(() -> {
            Thread thread = new Thread(notificator);
            thread.start();
            thread.interrupt(); // Interrupt the thread to stop it
        });
    }

    @Test
    void testShowNotification() {
        Task task = new Task("Test", new Date());
        assertDoesNotThrow(() -> Notificator.showNotification(task));
    }
}*/