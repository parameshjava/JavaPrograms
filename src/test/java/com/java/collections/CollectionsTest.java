package com.java.collections;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
		assertThat(Integer.compareUnsigned(productA.hashCode(), productB.hashCode()), is(0));
		assertNotSame(productA.hashCode(), productC.hashCode());
		
		productB = new Product(2, null, 1500.00);
		productC = new Product(1, "MotoX", 0);
		assertFalse(productB.equals(productC));
		assertNotSame(productB.hashCode(), productC.hashCode());
		
		productB = new Product(2, null, 0);
		productC = new Product(1, null, 0);
		assertTrue(productB.equals(productC));
		assertTrue(productB.equals(productB));
		assertFalse(productB.equals(null));
		assertThat(Integer.compareUnsigned(productB.hashCode(), productC.hashCode()), is(0));
		
		productB = new Product(2, "MotoX", 1600.50);
		productC = new Product(1, "MotoG", 1600.50);
		assertFalse(productB.equals(productC));
	}
}
