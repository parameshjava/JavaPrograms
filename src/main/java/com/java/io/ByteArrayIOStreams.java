package com.java.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayIOStreams {

    public void inputStream(byte[] buf) {
        ByteArrayInputStream b = new ByteArrayInputStream(buf);
        int availBytes = b.available();
        for (int i = 0; i < availBytes; i++) {
            int ascii = b.read();
            System.out.println(ascii);
            char c = (char) ascii;
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        for (int i = 0; i < 10; i++) {
            bout.write((byte) (Math.random() * 100));
        }

        byte[] byteArray = bout.toByteArray();
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}
