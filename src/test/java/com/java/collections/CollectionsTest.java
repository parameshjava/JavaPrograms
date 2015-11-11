package com.java.collections;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.java.collections.MapExample;

public class CollectionsTest {

	MapExample mapExample = new MapExample();
	
	@Test
	public void testHashTableDemo() {
		Map<String, Integer> map = mapExample.hashTableDemo();
		assertTrue(map instanceof Hashtable);
	}

	@Test
	public void testHashMapDemo() {
		Map<String, Integer> map = mapExample.hashMapDemo();
		assertTrue(map instanceof HashMap);
	}

	@Test
	public void testLinkedHashMapDemo() {
		Map<String, Integer> map = mapExample.linkedHashMapDemo();
		assertTrue(map instanceof LinkedHashMap);
		
	}

	@Test
	public void testSortedMapDemo() {
		Map<String, Integer> map = mapExample.sortedMapDemo();
		assertTrue(map instanceof TreeMap);
	}
	
	@Test
	public void testEquality() {
		Product productA = new Product(1, "MotoX", 1500.00);
		Product productB = new Product(2, "MotoX", 1500.00);
		Product productC = new Product(1, "MotoX", 1400.00);
		
		assertTrue(productA.equals(productB));
		assertFalse(productA.equals(productC));
	}
}
