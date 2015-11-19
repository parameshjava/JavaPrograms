package com.java.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public Map<String, Integer> hashTableDemo() {
        Map<String, Integer> map = new Hashtable<>();
        map.put("English", 88);
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("Social", 82);

        return map;
    }

    public Map<String, Integer> hashMapDemo() {
        Map<String, Integer> map = new HashMap<>();
        map.put("English", 88);
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("Social", 82);

        return map;
    }

    public Map<String, Integer> linkedHashMapDemo() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("English", 88);
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("Social", 82);

        return map;
    }

    public Map<String, Integer> sortedMapDemo() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("English", 88);
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("Social", 82);

        return map;
    }

}
