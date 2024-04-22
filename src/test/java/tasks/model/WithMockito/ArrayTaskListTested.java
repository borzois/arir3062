package tasks.model.WithMockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayTaskListTested {

    @Test
    void testAddNonNullTask() {
        ArrayTaskList list = new ArrayTaskList();
        Task task = Mockito.mock(Task.class);
        list.add(task);
        assertEquals(1, list.size());
        assertEquals(task, list.getTask(0));
    }

    @Test
    void testAddNullTask() {
        ArrayTaskList list = new ArrayTaskList();
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void testAddTaskWhenArrayIsFull() {
        ArrayTaskList list = new ArrayTaskList();
        for (int i = 0; i < 10; i++) {
            Task task = Mockito.mock(Task.class);
            list.add(task);
        }
        // Array should be full now, adding one more task should trigger resizing
        Task anotherTask = Mockito.mock(Task.class);
        list.add(anotherTask);
        assertEquals(11, list.size());
        assertEquals(anotherTask, list.getTask(10));
    }
}