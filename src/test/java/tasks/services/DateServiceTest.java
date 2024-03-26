package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class DateServiceTest {

    private DateService dateService;
    private TasksService tasksService;
    private ArrayTaskList tasks;
    @BeforeEach
    void setUp() {
        tasks = new ArrayTaskList();
        tasksService = new TasksService(tasks);
        dateService = new DateService(tasksService);
    }

    @Test
    void testGetLocalDateValueFromDate() {
        Date date = new Date();
        LocalDate localDate = dateService.getLocalDateValueFromDate(date);

        assertEquals(LocalDate.now(), localDate);
    }

    @Test
    void testGetDateValueFromLocalDate() {
        LocalDate localDate = LocalDate.now();
        Date date = dateService.getDateValueFromLocalDate(localDate);

        assertEquals(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), date);
    }

    @Test
    void testGetDateMergedWithTime() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.of(10, 30);
        Date mergedDate = dateService.getDateMergedWithTime(time.toString(), Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(mergedDate);

        assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
        assertEquals(30, calendar.get(Calendar.MINUTE));
    }

    @Test
    void testGetTimeOfTheDayFromDate() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.of(10, 30);
        Date dateTime = Date.from(date.atTime(time).atZone(ZoneId.systemDefault()).toInstant());

        String returnedTime = dateService.getTimeOfTheDayFromDate(dateTime);

        assertEquals("10:30", returnedTime);
    }
}
