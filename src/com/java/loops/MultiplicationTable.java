package com.java.loops;

/**
 * Prints the multiplication table up to the required number, in the below format.<br>
 * 
 *  * |  1  2  3  4  5<br>
 * --------------------<br>
 *  1 |  1  2  3  4  5<br>
 *  2 |  2  4  6  8 10<br>
 *  3 |  3  6  9 12 15<br>
 *  4 |  4  8 12 16 20<br>
 *  5 |  5 10 15 20 25<br>
 * 
 * @author Paramesh
 *
 */
public class MultiplicationTable {

	public static void printMul(int upto) {
		/*
		 * To manage the space b/w two numbers uniformly Suppose, if we want to
		 * print table upto 10 times, 10*10 = 100. As 100 occupies 3 characters
		 * and 1 space. So, length( upto * upto) + 1
		 */
		int spaces = String.valueOf(upto * upto).length() + 1;
		
		// 1. Print header line. This line consists of "  * | " and numbers 1 2 3 ... up to given range
		
		// 1.1 Print "*  |" in first line for first time with required number of spaces
		System.out.printf("%" + spaces + "s |", "*");
		
		// 1.2 Print numbers up to given range
		for (int i = 0; i < upto; i++) {
			System.out.format("%" + spaces + "s", i + 1);
		}

		System.out.println();
		// Print doted line (-----)
		// (spaces + 2) to print below " * | " and (upto * spaces) to print below upto given number
		for (int i = 0; i < ((spaces + 2) + (upto * spaces)); i++) {
			System.out.printf("%s", "-");
		}

		System.out.format("%n");

		for (int i = 1; i <= upto; i++) {
			System.out.printf("%" + spaces + "s |", i);
			for (int j = 1; j <= upto; j++) {
				System.out.format("%" + spaces + "s", (i * j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printMul(15);
	}

}
