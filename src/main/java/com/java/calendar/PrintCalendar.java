package com.java.calendar;

/**
 * Prints the calendar for given given month in a year.
 * 
 * @author Paramesh
 *
 */
public class PrintCalendar {
	
	//Reference for Odd Days : http://www.indiabix.com/aptitude/calendar/formulas
	static String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	static int[] monthlyDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**
	 * 
	 * @param day date [1 - 31]
	 * @param month Month [1-12]
	 * @param year any year
	 * @return Day which falls on the given date
	 */
	public static String getDay(int day, int month, int year) {
		// Store days in Array
		int oddDays = calculateOddDays(day, month, year);
		return days[oddDays];

	}

	/**
	 * Calculates odd days for the gien date based on the nearest 400th year.
	 * 
	 * @param day date [1 - 31]
	 * @param month Month [1- 12]
	 * @param year any year
	 * @return No. of days for the given date.
	 */
	public static int calculateOddDays(int day, int month, int year) {
		/*Since every 400 years, Odd days = 0, calculate total years from 
		 * nearest multiple of 400th year
		 */
		int totalYears = (year - 1) % 400;
		
		/* Calculate centuries, after nearest 400th century.
		 * Each century has 5 Odd days
		 */
		int centuries = totalYears / 100;
		
		// Extract remaining years after centuries, to calculate Normal Years and Leaf Years
		int numOfYears = totalYears % 100;
		
		// Leaf year has 2 Odd Days
		int leafYears = numOfYears / 4;
		
		// Normal year has only one Odd day
		int normalYears = numOfYears - leafYears;
		
		// Calculate Odd days upto previous year
		int oddDays = ((centuries * 5 ) + (leafYears * 2) + normalYears) % 7;
		
		int duration = 0;

		for (int i = 0; i < (month - 1); i++) {
			duration = duration + monthlyDays[i];
		}

		// For leaf year, odd days = 2 due to Feb. 100th year is not a leaf year but 400th Year is a leaf year
		duration = (isLeapYear(year) && month > 2) ? (duration + 1) : duration;
		
		oddDays = (oddDays + duration + day) % 7;
		
		return oddDays;
	}
	
	/**
	 * Determines whether the given year is Leap year or not.
	 * 
	 * @param year any year
	 * @return true if given year is a leap year, otherwise false
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 != 0) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Provides the calendar for the given month in a year.
	 * 
	 * @param month Month [1 - 12]
	 * @param year any year
	 * @return Calendar for the month
	 */
	public static String getCalender(int month, int year) {
		
		StringBuffer buffer = new StringBuffer();
		
		String format = "%" + 4 + "s";
		for (String day : days) {
			buffer.append(String.format("%4s", day));
		}
		buffer.append("\n");
		int oddDays = calculateOddDays(1, month, year);
		for (int i = 0; i < oddDays; i++) {
			buffer.append(String.format(format, " "));
		}
		
		// Add 1 extra day for February which falls under a Leap Year
		int daysInMonth = (month == 2 && isLeapYear(year)) ? (monthlyDays[month-1] + 1) : monthlyDays[month-1];
		for (int currDay = 1; currDay <= daysInMonth; currDay++) {
			buffer.append(String.format(format, currDay));
			if((currDay + oddDays) % 7 == 0) {
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}
}
