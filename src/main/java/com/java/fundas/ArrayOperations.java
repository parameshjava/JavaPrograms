package com.java.fundas;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayOperations {

    /**
     * Sorts the given array in Ascending order.
     * 
     * @param numbers The array which needs to perform ascending order.
     */
    public static void sort(int[] numbers, boolean isDes) {
        // Assuming always input array in not in ascending order.
        boolean isNextItrReq = true;

        while (isNextItrReq) {
            isNextItrReq = false;

            // Iterate array and compare two consecutive elements
            for (int index = 0; index < (numbers.length - 1); index++) {
                if (isDes) {
                    if (numbers[index] < numbers[index + 1]) {
                        // Swap the elements
                        /*int temp = numbers[index];
                        numbers[index] = numbers[index + 1];
                        numbers[index + 1] = temp;
                        // Since the elements got swapped, it requires another iteration to compare numbers[index] with its previous elements
                        isNextItrReq = true;*/

                        isNextItrReq = swapElements(numbers, index);
                    }
                } else {
                    if (numbers[index] > numbers[index + 1]) {
                        // Swap the elements
                        /*int temp = numbers[index];
                        numbers[index] = numbers[index + 1];
                        numbers[index + 1] = temp;
                        // Since the elements got swapped, it requires another iteration to compare numbers[index] with its previous elements
                        isNextItrReq = true;*/

                        isNextItrReq = swapElements(numbers, index);
                    }
                }
            }
        }
    }

    private static boolean swapElements(int[] numbers, int index) {
        numbers[index] = numbers[index] + numbers[index + 1];
        numbers[index + 1] = numbers[index] - numbers[index + 1];
        numbers[index] = numbers[index] - numbers[index + 1];
        return true;
    }

    public static String printElements(int[] numbers) {
        StringBuffer buffer = new StringBuffer("[");
        for (int num : numbers) {
            buffer.append(num).append(",");
        }
        buffer.delete((buffer.length() - 1), buffer.length());
        return buffer.append("]").toString();
    }

    /**
     * Calculates the number of duplicate elements present in the given array.
     * 
     * @param numbers Array in which we need to find the number of duplicates.
     * @return duplicate count.
     */
    public static int countDuplicates(int[] numbers) {
        int duplicateCount = 0;

        // 1. Sort the elements in ascending order
        sort(numbers, false);
        // 2. Compare two consecutive elements to find the duplicate count
        for (int index = 0; index < (numbers.length - 1); index++) {
            // Compare two elements, if found both are same increment the duplicate count
            if (numbers[index] == numbers[index + 1]) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    /**
     * Removes the duplicate elements present in the array.
     * 
     * @param numbers Array in which needs to eliminate duplicates.
     * @return Unique elements array.
     */
    public static int[] removeDuplicates(int[] numbers) {
        int dupCount = countDuplicates(numbers);
        int[] uniqueArr = new int[numbers.length - dupCount];

        // Populate first element, since its always unique
        uniqueArr[0] = numbers[0];
        int lastPopulatedIndex = 0;

        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] != uniqueArr[lastPopulatedIndex]) {
                //The current element in the original array is not same with the last populated element,
                // Hence, adding the element to the unique array and incrementing the lastPopulatedIndex by 1.
                uniqueArr[++lastPopulatedIndex] = numbers[index];
            }
        }

        return uniqueArr;
    }

    /**
     * Converts the given String array to integer array.
     * 
     * @param array String array
     * @return int array
     */
    public static int[] convert(String[] array) {
        int[] numbers = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            // Pick the current element from the String array
            String str = array[index];
            // Convert the String to integer
            int num = Integer.parseInt(str);
            // Populate the array with the current integer at right index
            numbers[index] = num;
        }

        return numbers;
    }

    /**
     * Converts the given char array to integer array.
     * 
     * @param array char array
     * @return int array
     */
    public static int[] convert(char[] array) {
        int[] numbers = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            numbers[index] = array[index];
        }

        return numbers;
    }

    public static char[] convertStringToChar(String[] array) {
        char[] alphas = new char[array.length];
        for (int index = 0; index < array.length; index++) {
            alphas[index] = array[index].charAt(0);
        }
        return alphas;
    }

    /**
     * Calculates the sum of elements present in the array.
     * 
     * @param numbers Array for which needs to calculate sum
     * @return Summation of all elements
     */
    public static int summation(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static ArrayList<Integer> maxSubArraySum(int[] array) {
        int start = 0, end = 0;
        int maxsum = 0, sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxsum) {
                maxsum = sum;
                start = end;
                end = i;
            }
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(maxsum);
        al.add(start);
        al.add(end);
        return al;
    }

    public static void main(String[] args) {
        int[] numbers = {50, 30, 10, 5, 20, 80, 90, 12};
        sort(numbers, false);
        System.out.println("Array in sorting order : " + Arrays.toString(numbers));
        sort(numbers, true);
        System.out.println("Array in sorting order : " + Arrays.toString(numbers));

        int[] numbers2 = {50, 30, 10, 50, 20, 20, 90, 12};
        System.out.println("Original Array : " + Arrays.toString(numbers2));
        int[] uniqueArr = removeDuplicates(numbers2);
        System.out.println("Unique Array : " + Arrays.toString(uniqueArr));

        int[] numbers3 = {-50, 30, 10, 5, 20, 80, -90, 12};
        ArrayList<Integer> nums = maxSubArraySum(numbers3);
        System.out.println(nums);
    }
}
