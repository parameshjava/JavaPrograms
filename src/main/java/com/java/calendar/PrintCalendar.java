package com.java.calendar;

/**
 * Prints the calender for given given month in a year.
 * 
 * @author Paramesh
 *
 */
public class PrintCalendar {
	
	// http://www.indiabix.com/aptitude/calendar/formulas
	static String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
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
			duration = duration + daysInMonth[i];
		}

		// For leaf year, odd days = 2 due to Feb. 100th year is not a leaf year but 400th Year is a leaf year
		duration = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) && month > 2) ? (duration + 1) : duration;
		
		oddDays = (oddDays + duration + day) % 7;
		
		return oddDays;
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
		
		for (int currDay = 1; currDay <= daysInMonth[month-1]; currDay++) {
			buffer.append(String.format(format, currDay));
			if((currDay + oddDays) % 7 == 0) {
				buffer.append("\n");
			}
		}
		return buffer.toString();
	}

	public static void main(String[] args) {

		String day = getDay(1, 11, 2015);
		System.out.println("Given day : " + day);

		String day1 = getDay(1, 1, 1);
		System.out.println("Given day : " + day1);
		System.out.println(getCalender(3, 1900));
		System.out.println();
		System.out.println(getCalender(11, 2015));
	}

}
