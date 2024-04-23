package tasks.model.WithMockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Integrare_E {

    @Test
    void testAddTaskAndGetSize() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = Mockito.mock(Task.class);

        list.add(task);

        assertEquals(1, service.getObservableList().size());
    }

    @Test
    void testAddTaskAndGetSizeAddNull() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = Mockito.mock(Task.class);
        Task tasku = Mockito.mock(Task.class);
        Task taske = Mockito.mock(Task.class);
        Task taskr = Mockito.mock(Task.class);


        list.add(task);
        list.add(tasku);
        list.add(taske);
        list.add(taskr);

        assertEquals(4, service.getObservableList().size());
    }

    @Test
    void testGetIntervalInHours() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = Mockito.mock(Task.class);
        when(task.getRepeatInterval()).thenReturn(3600);

        list.add(task);

        String interval = service.getIntervalInHours(task);
        assertEquals("01:00", interval);
    }
    @Test
    void testGetIntervalInHours2() {
        ArrayTaskList list = new ArrayTaskList();
        TasksService service = new TasksService(list);

        Task task = Mockito.mock(Task.class);
        when(task.getRepeatInterval()).thenReturn(7260);

        list.add(task);

        String interval = service.getIntervalInHours(task);
        assertEquals("02:01", interval);
    }
}