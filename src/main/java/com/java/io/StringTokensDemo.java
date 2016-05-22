package com.java.io;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokensDemo {

    public static void main(String[] args) {
        
        String str = "This is a smaple test, just sending to my friend to know whether program is working or not.";
        StringTokenizer tokenizer = new StringTokenizer(str, " ,.");
        String[] words = new String[tokenizer.countTokens()];
        int index = 0;
        while(tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            words[index++] = word;
        }
        System.out.println(Arrays.toString(words));
    }
}
