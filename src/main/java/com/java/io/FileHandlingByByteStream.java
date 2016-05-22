package com.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileHandlingByByteStream {

    public String readFile(String filePath) {
        StringBuffer buffer = new StringBuffer();
        //File file = new File(filePath);
        try (InputStream inputStream = new FileInputStream(filePath)) {

            int availableChars = inputStream.available();
            for (int i = 0; i < availableChars; i++) {
                // Every character coming to Java program externalyy, it should be an ascii value
                int ascii = inputStream.read();
                // Convert ascii value to its equivalent character
                char c = (char) ascii;
                buffer.append(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return buffer.toString();
    }

    public void writeTOFile(String filePath) {
        File file = new File(filePath);
        try (OutputStream outPutStream = new FileOutputStream(file)) {
            // Some content should send to file
            String myStr1 = "This is my first string sending to file by using byte oriented stream.";
            String myStr2 = "This is my second string sending to file by using byte oriented stream.";
            outPutStream.write(myStr1.getBytes());
            outPutStream.write("\n".getBytes());
            outPutStream.write(myStr2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\PARAMESH\\LOGS\\students.txt";
        FileHandlingByByteStream fhbs = new FileHandlingByByteStream();
        //fhbs.writeTOFile(filePath);
        String fileContent = fhbs.readFile(filePath);
        System.out.println(fileContent);
    }
}
