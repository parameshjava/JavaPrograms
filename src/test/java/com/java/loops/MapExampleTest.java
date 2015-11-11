package com.java.loops;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.java.collections.MapExample;

public class MapExampleTest {

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

}
