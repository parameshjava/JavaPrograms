package com.java.enumerator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DayTest {

    @Test
    public void testGetDays() {
        List<String> days = Day.getDays();
        assertEquals(7, days.size());
        assertEquals("MONDAY", days.get(0));
    }

    @Test
    public void testGetValues() {

        boolean isMondayHoliday = Day.isDayHoliday("MONDAY");
        boolean isSatHoliday = Day.isDayHoliday("saturday");

        assertFalse(isMondayHoliday);
        assertTrue(isSatHoliday);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetValuesForException() {
        Day.isDayHoliday("XXXXX");
    }

    @Test
    public void testGetValuesForExceptionMessage() {
        String weekDay = "XXXXX";
        try {
            Day.isDayHoliday(weekDay);
        } catch (IllegalArgumentException iae) {
            assertEquals("Invalid parameter " + weekDay, iae.getMessage());
        }
    }
}
