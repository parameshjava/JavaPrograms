package com.java.reverse;

/**
 * This demonstrate how to reverse a given String
 * 
 * @author pkorraku
 *
 */
public class StringReverse {

    /**
     * Reverse a given string by using recursive technique
     * 
     * @param str string to be reverse
     * @return reversed string
     */
    public static String reverseRecursive(String str) {
        if (str.length() > 1) {
            return reverseRecursive(str.substring(1)) + str.charAt(0);
        }
        return str;
    }

    /**
     * Reverse a given string by iterating in backword direction
     * 
     * @param str string to be reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        StringBuffer buffer = new StringBuffer();
        for (int index = (str.length() - 1); index >= 0; index--) {
            buffer.append(str.charAt(index));
        }
        return buffer.toString();
    }
}
