package com.java.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapExample.class);

    public Map<String, Integer> poupateMap(Map<String, Integer> map) {
        map.put("English", 88);
        
        
        
        map.put("Kannada", 85);
        map.put("Hindi", 86);
        map.put("Maths", 99);
        map.put("Science", 90);
        map.put("Social", 82);

        return map;
    }

    public Map<String, Integer> hashTableDemo() {
        Map<String, Integer> map = new Hashtable<>();

        return poupateMap(map);
    }

    public Map<String, Integer> hashMapDemo() {
        Map<String, Integer> map = new HashMap<>();

        return poupateMap(map);
    }

    public Map<String, Integer> linkedHashMapDemo() {
        Map<String, Integer> map = new LinkedHashMap<>();

        return poupateMap(map);
    }

    public Map<String, Integer> sortedMapDemo() {
        Map<String, Integer> map = new TreeMap<>();

        return poupateMap(map);
    }

    public void iterateMapByEntries(Map<String, Integer> map) {
        LOGGER.info("---- Iterating map by using Entries ----");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(String.format("Key = %s & value = %s", entry.getKey(), entry.getValue()));
        }
    }

    public void iterateMapByUsingKeys(Map<String, Integer> map) {
        LOGGER.info("---- Iterating map by using Keys ----");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(String.format("Key = %s & value = %s", key, map.get(key)));
        }
    }

}
