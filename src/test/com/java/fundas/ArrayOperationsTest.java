package com.java.fundas;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTest {

	@Test
	public void sortTest() {
		int[] arr = { 10, 30, 40, 90, 20, 67, 60 };
		ArrayOperations.sort(arr, false);
		int[] sortedArray = { 10, 20, 30, 40, 60, 67, 90 };
		Assert.assertArrayEquals(sortedArray, arr);
	}

	@Test
	public void sortDescTest() {
		int[] arr = { 10, 30, 40, 90, 20, 67, 60 };
		ArrayOperations.sort(arr, true);
		int[] sortedArray = { 90, 67, 60, 40, 30, 20, 10 };
		Assert.assertArrayEquals(sortedArray, arr);
	}
}
