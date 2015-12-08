package com.java.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapExample {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MapExample.class);

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
        map.put("Social", 88);
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("English", 82);

        return map;
    }

    public Map<String, Integer> sortedMapDemo() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Kannada", 88);
        map.put("English", 85);
        map.put("Science", 90);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Social", 82);

        return map;
    }

    public static void main(String[] args) {
        MapExample example = new MapExample();
        LOGGER.info("Hashtable : " + example.hashTableDemo());
        LOGGER.info("HashMap : " + example.hashMapDemo());
        LOGGER.info("LinkedHashMap : " + example.linkedHashMapDemo());
        LOGGER.info("TreeMap : " + example.sortedMapDemo());
    }
}
