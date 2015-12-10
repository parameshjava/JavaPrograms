package com.java.control.statements;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Menu driven program, by default it will display list of available options for first time.
 * Based on the user input, it will decide whether to reiterate the program or exit.
 * 
 * @author Paramesh
 *
 */
public class MenuDriven {
    
    /**
     * Calculates sum of the elements given array
     * 
     * @param numbers Array of numbers in the form of strings
     * @return sum of the given array elements
     */
    public static int summation(String... numbers) {
        int sum = 0;
        for (String number : numbers) {
            // Converting String to Integer, since Operator + will performs concatenates if any one element is in String format, 
            //instead of performing addition
            sum += Integer.parseInt(number);
        }
        return sum;
    }
    
    /**
     * Generates fibonacci series upto the given range
     * 
     * @param range fibonacci series required upto the range
     * @return fibonacci series
     */
    public static String fibonacciSeries(int range) {
        // Since concatenation on Strings is immutable, using StringBuffer
        StringBuilder builder = new StringBuilder();
        // In fibonacci series by default first two numbers are 1 & 2
        int firstNumber = 1;
        int secondNumber = 2;
        
        // Adding first two default numbers to the sequence
        builder.append(firstNumber).append(", ").append(secondNumber);
        int nextNumber = 0;
        
        // Generate the sequence upto the given range
        while(nextNumber <= range) {
            // Calculate the next number in the sequence by adding last two numbers
            nextNumber = firstNumber + secondNumber;
            if (nextNumber <= range) {
                // Add the generated number to the fibonacci series
                builder.append(", ").append(nextNumber);
                // perform swapping operation for the next iteration
                firstNumber = secondNumber;
                secondNumber = nextNumber;
            }
        }
        // Converts StringBuffer to String and return the series to the client
        return builder.toString();
    }
    
    /**
     * Generates prime numbers upto the given range
     * 
     * @param range required range
     * @return prime numbers sequence
     */
    public static String primeNumberSeries(int range) {
        StringBuilder builder = new StringBuilder();
        // By default 2 is prime
        builder.append("2");
        
        // Since all the even numbers are not prime, we are skipping even numbers
        for (int currentNumber = 3; currentNumber <= range; currentNumber = (currentNumber + 2)) {
            // Initially assume current number is a prime
            boolean isPrime = true;
            for (int factor = 3; factor <= (currentNumber / 2); factor++) {
                if(currentNumber % factor == 0) {
                    // Update current number is not a prime, when it has factor
                    isPrime = false;
                    // Since it has a factor and no need to continue the loop
                    break;
                }
            }
            // Add current number to the series, when there is no factor available
            if(isPrime) {
                builder.append(", ").append(currentNumber); 
            }
        }
        return builder.toString();
    }
    
    /**
     * Sorts the given String array in descending order
     * 
     * @param numbers array of strings
     * @return descending order sorted array
     */
    public static int[] sortDescending(String[] numbers) {
        // Since numbers in String format cannot comparable, Convert String to Integer array.
        int[] array = convertStringToInt(numbers);
        
        // Initially always assume that, there is swapping required
        boolean isSwapped = true;
        
        // Continue the operation till there is no sorting required
        while (isSwapped) {
            // Initially make the flag as not swapped
            isSwapped = false;
            for (int index = 0; index < array.length - 1; index++) {
                // Swap the elements, if the first number is less next number in the array
                if(array[index] < array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index+1] = temp;
                    // Update the flag as swapped
                    isSwapped = true;
                }
            } 
        }
        return array;
    }

    /**
     * Converts given String array to Integer array
     * 
     * @param numbers String array
     * @return integer array
     */
    public static int[] convertStringToInt(String[] numbers) {
        int[] intArr = new int[numbers.length];
        for (int index = 0; index < numbers.length; index++) {
            int number = Integer.parseInt(numbers[index]);
            intArr[index] = number;
        }
        return intArr;
    }

    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please choose the options [1-4] from below menu");
            System.out.println("1. Calculate sum of all given numbers");
            System.out.println("2. Generate fibonacci series upto given number");
            System.out.println("3. Generate prime numbers series upto given number");
            System.out.println("4. Sort the given array in descending order");
            System.out.println("--------------------------------------------------");
            System.out.println("Please enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
            case 1:
                System.out.println("Please enter the numbers separated by comma to calculate the sum");
                String[] numbersForSum = sc.next().split(",");
                int sum = summation(numbersForSum);
                System.out.println("Sum of given numbers : " + sum);
                break;
            case 2:
                System.out.println("Please enter the range to generate fibonacci series : ");
                int fibonacciRange = sc.nextInt();
                String fibonacciSeries = fibonacciSeries(fibonacciRange);
                System.out.println("Fibonacci series : " + fibonacciSeries);
                break;
            case 3:
                System.out.println("Please enter tha range to generate prime number series : ");
                int primeRange = sc.nextInt();
                String primeSeries = primeNumberSeries(primeRange);
                System.out.println("Prime numbers : " + primeSeries);
                break;
            case 4:
                System.out.println("Please enter the numbers separated by comma to sort in descending order :");
                String[] numbersForSort = sc.next().split(",");
                int[] sortedArray = sortDescending(numbersForSort);
                System.out.println("Desending order sorted Array : " + Arrays.toString(sortedArray));
                break;
            default:
                System.out.println("Not chosen correct option, exiting from the loop");
            }
        } while (choice >= 1 && choice <= 4);
        sc.close();
    }

}
