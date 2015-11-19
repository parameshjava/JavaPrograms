package com.java.loops;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prints the multiplication table up to the required number.
 * 
 * @author Paramesh
 *
 */
public class MultiplicationTable {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MultiplicationTable.class);

    public static String printMultiplicationTable(int upto) {
        /* Since String is immutable, using StringBuffer for concatenating
         * several string to generate multiplication table
         */
        StringBuffer buffer = new StringBuffer();

        /*
         * To manage the space b/w two numbers uniformly. Suppose, if we want to print multiplication table for 10, the highest number will be 10*10 = 100.
         * As 100 occupies 3 characters and 1 space. So, we need to allocate space for each digit is lengthOf(upto * upto) + 1
         */
        int spaces = String.valueOf(upto * upto).length() + 1;

        // 1. Print header line. This line consists of "  * | " and numbers 1 2 3 ... up to given range

        // 1.1 Print "*  |" in first line for first time with required number of spaces
        buffer.append(String.format("%" + spaces + "s |", "*"));

        // 1.2 Print numbers up to given range
        for (int i = 1; i <= upto; i++) {
            buffer.append(String.format("%" + spaces + "s", i));
        }

        buffer.append("\n");
        // Print doted line (-----)
        // (spaces + 2) to print below " * | " and (upto * spaces) to print below upto given number
        for (int i = 1; i < ((spaces * 2) + (upto * spaces)); i++) {
            buffer.append(String.format("%s", "-"));
        }

        buffer.append("\n");

        for (int i = 1; i <= upto; i++) {
            buffer.append(String.format("%" + spaces + "s |", i));
            for (int j = 1; j <= upto; j++) {
                buffer.append(String.format("%" + spaces + "s", (i * j)));
            }
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
