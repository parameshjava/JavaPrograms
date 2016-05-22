package com.java.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.io.FileHandlingByByteStream;

import junit.framework.TestCase;

public class FileHandlingByStreamTest extends TestCase {

    FileHandlingByByteStream stream;

    @Before
    public void setUp() {
        stream = new FileHandlingByByteStream();
    }

    @Test
    public void testReadFile() {
        String filePath = new File("").getAbsolutePath().concat(File.separator)
                .concat(String.join(File.separator, "src", "test", "resources", "ByteStreamFile.txt"));
        String str = stream.readFile(filePath);
        String[] strings = str.split("\n");

        Assert.assertEquals("This is my first string sending to file by using byte oriented stream.", strings[0]);
        Assert.assertEquals("This is my second string sending to file by using byte oriented stream.", strings[1]);
    }

}
