package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.model.LinkedTaskList;
import tasks.model.TaskList;
import tasks.services.TaskIO;

import java.io.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskIOTest {
    private TaskIO taskIO;
    private TaskList tasks;

    @BeforeEach
    void setUp() {
        tasks = new LinkedTaskList();
        taskIO = new TaskIO();
    }

    @Test
    void testWriteAndReadBinary() throws IOException {
        Task task = new Task("Test", new Date());
        tasks.add(task);
        File tempFile = File.createTempFile("temp", null);
        taskIO.writeBinary(tasks, tempFile);
        TaskList readTasks = new LinkedTaskList();
        taskIO.readBinary(readTasks, tempFile);
        assertEquals(1, readTasks.size());
        assertEquals(task.getTitle(), readTasks.getTask(0).getTitle());
    }

    @Test
    void testWriteAndRead() throws IOException {
        Task task = new Task("Test", new Date());
        tasks.add(task);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        taskIO.write(tasks, out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        TaskList readTasks = new LinkedTaskList();
        taskIO.read(readTasks, in);
        assertEquals(1, readTasks.size());
        assertEquals(task.getTitle(), readTasks.getTask(0).getTitle());
    }

    @Test
    void testWriteTextAndReadText() throws IOException {
        Task task = new Task("Test", new Date());
        tasks.add(task);
        File tempFile = File.createTempFile("temp", null);
        taskIO.writeText(tasks, tempFile);
        TaskList readTasks = new LinkedTaskList();
        taskIO.readText(readTasks, tempFile);
        assertEquals(1, readTasks.size());
        assertEquals(task.getTitle(), readTasks.getTask(0).getTitle());
    }
}
