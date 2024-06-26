package tasks.model.WithMockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Integrare_E {

    @Test
    public void testAddTaskAndGetSize() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = new Task("Task", new Date(1), new Date(2), 80);

        list.add(task);

        assertEquals(1, service.getObservableList().size());
    }

    @Test
    public void testAddTaskAndGetSizeAddNull() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = new Task("Task", new Date(), new Date(), 3600);
        Task tasku = new Task("Tasku", new Date(), new Date(), 69);
        Task taske = new Task("Taske", new Date(), new Date(), 600);
        Task taskr = new Task("Taskr", new Date(), new Date(), 36);


        list.add(task);
        list.add(tasku);
        list.add(taske);
        list.add(taskr);

        assertEquals(4, service.getObservableList().size());
    }

    @Test
    public void testGetIntervalInHours() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = new Task("Task", new Date(), new Date(), 3600);

        list.add(task);

        String interval = service.getIntervalInHours(task);
        assertEquals("01:00", interval);
    }
    @Test
    public void testGetIntervalInHours2() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = new Task("Task", new Date(), new Date(), 7260);
        list.add(task);

        String interval = service.getIntervalInHours(task);
        assertEquals("02:01", interval);
    }
}