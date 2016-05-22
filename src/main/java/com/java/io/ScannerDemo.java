package com.java.io;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please provide String input : ");
        String str = sc.next();
        System.out.println("Given String : " + str);
        
        System.out.println("Please prvide int input : ");
        int i = sc.nextInt();
        System.out.println("Given int is : " + i);
        
        System.out.println("Please provide long input : ");
        long l = sc.nextLong();
        System.out.println("Given Long is : " + l);
        
        // Close the scanner object
        sc.close();
    }

}
