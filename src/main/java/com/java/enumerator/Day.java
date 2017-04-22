/**
 * 
 */
package com.java.enumerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paramesh
 *
 */
public enum Day {
    
    MONDAY("MONDAY", 1, false),
    TUESDAY("TUESDAY", 2, false),
    WEDNESSDAY("WEDNESSDAY", 3, false),
    THURSDAY("THURSDAY", 4, false), 
    FRIDAY("FRIDAY", 5, false), 
    SATURDAY("SATURDAY", 6, true), 
    SUNDAY("SUNDAY", 7, true);
    
    
    
    
    
    String name;
    int index;
    boolean isHoliday;
    
    private Day(String name, int index, boolean isHoliday) {
        this.name = name;
        this.index = index;
        this.isHoliday = isHoliday;
    }
    
    public static List<String> getDays() {
        List<String> days = new ArrayList<>();
        
        for (Day day : Day.values()) {
            days.add(day.name);
        }
        return days;
    }

    /**
     * 
     * @param weekDay Day name of the week
     * @return true if given day is Holiday, otherwise false
     * @throws IllegalArgumentException when given argument is not matched with any variable in {@link Day}
     */
    public static boolean isDayHoliday(String weekDay) throws IllegalArgumentException {
        
        for (Day day : Day.values()) {
            if (weekDay.equalsIgnoreCase(day.name)) {
                return day.isHoliday;
            }
        }
        throw new IllegalArgumentException("Invalid parameter " + weekDay);
    }
}
