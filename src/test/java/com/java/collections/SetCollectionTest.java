package com.java.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class SetCollectionTest extends TestCase {

    @Test
    public void testGetUniquleElements() {
        String[] strings = {"Rahul", "Sonia", "Laloo", "Laloo"};
        Set<String> uniqElements = SetCollection.getUniquleElements(strings);
        Assert.assertEquals(3, uniqElements.size());
    }

    @Test
    public void testGetUniqueAndOrderCollection() {
        List<String> list = Arrays.asList("Hyderabad", "Mumbai", "Bangalore", "Hyderabad", "Gujarath", "Mumbai");
        Set<String> set = SetCollection.getUniqueAndOrderCollection(list);
        Assert.assertEquals(4, set.size());
        int currentIndex = 0;
        for (String str : set) {
            switch (currentIndex) {
                case 0:
                    Assert.assertEquals("Bangalore", str);
                    break;
                case 1:
                    Assert.assertEquals("Gujarath", str);
                    break;
                case 2:
                    Assert.assertEquals("Hyderabad", str);
                    break;
                case 3:
                    Assert.assertEquals("Mumbai", str);
            }
            currentIndex++;
        }
    }

    @Test
    public void testSortSetDescending() {
        Set<Integer> set = new HashSet<>();
        // How to add multiple elements in set at a time
        set.addAll(Arrays.asList(10, 20, 30, 12, 56, 89, 20));

        List<Integer> list = SetCollection.sortSetDescending(set);
        Assert.assertEquals(Integer.valueOf(89), list.get(0));
        Assert.assertEquals(Integer.valueOf(56), list.get(1));
        Assert.assertEquals(Integer.valueOf(30), list.get(2));
        Assert.assertEquals(Integer.valueOf(20), list.get(3));
        Assert.assertEquals(Integer.valueOf(12), list.get(4));
        Assert.assertEquals(Integer.valueOf(10), list.get(5));
    }
}
