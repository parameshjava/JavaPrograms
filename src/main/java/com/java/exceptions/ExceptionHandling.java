package com.java.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandling {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandling.class);

    /**
     * Converts the given String arguments into Integers and calculate the sum of all.
     * It is capable to handle the exception when the given string not
     * in the form of number
     * 
     * @param numbers
     *            variable number of String arguments
     * @return sum of all given numbers
     */
    public static int summation(String... numbers) {
        int sum = 0;
        for (String number : numbers) {
            LOGGER.debug("Processing : {}", number);
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException nfe) {
                /*
                 * In the absence of this try - catch block, when JVM trying to
                 * convert String "abc" to number, its generate NumberFormatException exception and reaches the same runtime
                 * environment.
                 */
                LOGGER.error("Given input number : " + number + " is not a number, so cannot include in sum calculation");
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum1 = summation("1", "3", "abc", "5");
        LOGGER.info("Sum1 = " + sum1);
    }

}
