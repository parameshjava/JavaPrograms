package com.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang.StringUtils;

public class SerializationDemo {

    public static void serialization(Object obj, String filePath) {
        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void deSerialization(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            Object obj = ois.readObject();
            
            if(obj instanceof Television) {
                Television tv = (Television) obj;
                System.out.println(tv.toString());
            } else if(obj instanceof Mobile) {
                Mobile mobile = (Mobile) obj;
                System.out.println(mobile.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Mobile mobile = new Mobile(10, "MotoX", 13999.00, 2, 16);
        Television tv = new Television(100, "Samsung", 31999, "30%25");
        
        String tvPath = "C:\\PARAMESH\\LOGS\\tv.txt";
        String mobilePath = "C:\\PARAMESH\\LOGS\\mobile.txt";
        serialization(mobile, mobilePath);
        serialization(tv, tvPath);
        
        // Deserialization
        System.out.println("TV Before Serialized : ");
        System.out.println(tv.toString());
        deSerialization(tvPath);
        //deSerialization(mobilePath);
        
        String str = "";
        StringUtils.isBlank("    ");
    }

}
