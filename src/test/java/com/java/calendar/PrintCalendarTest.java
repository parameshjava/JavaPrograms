package com.java.calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PrintCalendarTest {

	@Test
	public void testGetDay() {
		String day1 = PrintCalendar.getDay(11, 11, 2015);
		String day2 = PrintCalendar.getDay(11, 11, 2016);
		assertThat("Wed", is(day1));
		assertThat("Fri", is(day2));
	}

	@Test
	public void testCalculateOddDays() {
		int oddDays = PrintCalendar.calculateOddDays(5, 10, 500);
		assertThat(2, is(oddDays));
		
	}

	@Test
	public void testGetCalender() {
		String calendar = PrintCalendar.getCalender(11, 2015);
		
		assertNotNull(calendar);
		String[] rows = calendar.split("\n");
		assertThat(6, is(rows.length));
		assertTrue(rows[0].contains(" Sun Mon Tue Wed Thu Fri Sat"));
		assertTrue(rows[1].contains("   1   2   3   4   5   6   7"));
		assertTrue(rows[2].contains("   8   9  10  11  12  13  14"));
		assertTrue(rows[3].contains("  15  16  17  18  19  20  21"));
		assertTrue(rows[4].contains("  22  23  24  25  26  27  28"));
		assertTrue(rows[5].contains("  29  30"));
	}

}
