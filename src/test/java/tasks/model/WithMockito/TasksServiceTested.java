package tasks.model.WithMockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.Task;
import tasks.services.TasksService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TasksServiceTested {

    @Test
    void testGetIntervalInHoursOneHour() {
        Task task = Mockito.mock(Task.class);
        when(task.getRepeatInterval()).thenReturn(3600); // 1 hour in seconds

        TasksService service = new TasksService(null);
        String interval = service.getIntervalInHours(task);

        assertEquals("01:00", interval);
    }

    @Test
    void testGetIntervalInHoursTwoAndHalfHours() {
        Task task = Mockito.mock(Task.class);
        when(task.getRepeatInterval()).thenReturn(9000); // 2.5 hours in seconds

        TasksService service = new TasksService(null);
        String interval = service.getIntervalInHours(task);

        assertEquals("02:30", interval);
    }

    @Test
    void testGetIntervalInHoursZeroHours() {
        Task task = Mockito.mock(Task.class);
        when(task.getRepeatInterval()).thenReturn(0); // 0 hours in seconds

        TasksService service = new TasksService(null);
        String interval = service.getIntervalInHours(task);

        assertEquals("00:00", interval);
    }
}