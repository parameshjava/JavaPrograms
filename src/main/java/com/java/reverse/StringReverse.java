package com.java.reverse;

public class StringReverse {

	public static String reverseRecursive(String str) {
		if (str.length() > 1) {
			return reverseRecursive(str.substring(1)) + str.charAt(0);
		}
		return str;
	}
	
	public static String reverseString(String str) {
		StringBuffer buffer = new StringBuffer();
		for (int index = (str.length() - 1); index >= 0; index--) {
			buffer.append(str.charAt(index));
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println("1. " + reverseRecursive("Paramesh"));
		System.out.println("2. " + reverseString("Paramesh"));
	}

}
