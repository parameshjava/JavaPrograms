package com.java.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHanldingByCharacterStream {

    public void writeToFIle(String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            String str1 = "This is my first String sending to file by using character oriented stream.";
            String str2 = "This is my second String sending to file by using character oriented stream.";

            fw.write(str1);
            fw.write("\n");
            fw.write(str2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String filePath) {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader  br = new BufferedReader(new FileReader(filePath))) {
            String str;
            while((str = br.readLine()) != null) {
                buffer.append(str).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        FileHanldingByCharacterStream handling = new FileHanldingByCharacterStream();
        handling.writeToFIle("C:\\PARAMESH\\LOGS\\JAVA_IO.txt");
        String str = handling.readFromFile("C:\\PARAMESH\\LOGS\\JAVA_IO.txt");
        System.out.println(str);
    }
}