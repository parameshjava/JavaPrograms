package com.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetCollection {

    /**
     * Eliminates duplicates from array and creates Set of Strings
     * @param arr Array of Strings
     * @return Unique collection from Array
     */
    public static Set<String> getUniquleElements(String[] arr) {
        // Create a new set
        Set<String> set = new HashSet<>();

        // Iterate a each element in array and add too Set
        for (String str : arr) {
            // How to add elements to the Set
            set.add(str);
        }
        return set;
    }

    public static Set<String> getUniqueAndOrderCollection(List<String> strings) {
        Set<String> set = new TreeSet<>();
        for (String str : strings) {
            set.add(str);
        }
        return set;
    }

    public static List<String> convertToList(Set<String> strSet) {
        List<String> list = new ArrayList<>();
        for (String str : strSet) {
            list.add(str);
        }

        return list;

    }
    
    public static List<Integer> sortSetDescending(Set<Integer> numbers) {
        // How to create Array List from Set
        List<Integer> list = new ArrayList<>(numbers);
        
        // How to sort the collection in reverse order
        Collections.sort(list, Collections.reverseOrder());
        
        return list;
        
    }

}
