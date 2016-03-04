package com.java.fundas;

import java.util.*;

public class YourNumberMyWord {
    public void pw(int n, String ch) {
        String one[] = {" ", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
                " eleven", " twelve", " thirteen", " fourteen", "fifteen", " sixteen", " seventeen", " eighteen",
                " nineteen"};

        String ten[] = {" ", " ", " twenty", " thirty", " forty", " fifty", " sixty", "seventy", " eighty", " ninety"};

        if (n > 19) {
            System.out.print(ten[n / 10] + " " + one[n % 10]);
        } else {
            System.out.print(one[n]);
        }
        if (n > 0)
            System.out.print(ch);
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanf = new Scanner(System.in);
        System.out.println("Enter an integer number: ");
        n = scanf.nextInt();

        if (n <= 0)
            System.out.println("Enter numbers greater than 0");
        else {
            YourNumberMyWord a = new YourNumberMyWord();
            a.pw((n / 1000000000), " Hundred");
            a.pw((n / 10000000) % 100, " crore");
            a.pw(((n / 100000) % 100), " lakh");
            a.pw(((n / 1000) % 100), " thousand");
            a.pw(((n / 100) % 10), " hundred");
            a.pw((n % 100), " ");
        }
    }
}
