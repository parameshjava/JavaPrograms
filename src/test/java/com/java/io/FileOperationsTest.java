package com.java.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.Test;

public class FileOperationsTest {

	@Test
	public void testListWordsWithOccurance() throws FileNotFoundException, IOException {
		File file = new File("src/test/resources/test_file.txt").getAbsoluteFile();
		Map<String, Integer> actualWordMap = FileOperations.listWordsWithOccurance(file.getPath());
		assertNotNull(actualWordMap);
		Map<String, Integer> expectedWordMap = new HashMap<>();
		expectedWordMap.put("this", 10);
		expectedWordMap.put("is", 8);
		expectedWordMap.put("test", 9);
		assertTrue(Objects.equals(expectedWordMap, actualWordMap));
	}

	@Test
	public void testFilterMaxOccurance() {
		Map<String, Integer> wordsMap = new HashMap<>();
		wordsMap.put("Rahul", 15);
		wordsMap.put("Ranjith", 12);
		wordsMap.put("Aruna", 10);
		List<String> actualList = FileOperations.filterMaxOccurance(wordsMap, 2);
		assertNotNull(actualList);
		assertEquals(actualList.size(), 2);

		List<String> expectedList = Arrays.asList("Rahul : 15", "Ranjith : 12");
		assertTrue(Objects.equals(expectedList, actualList));
	}

    @Test(expected = IOException.class)
    public void testListWordsWithOccuranceWithInvalidPath() throws FileNotFoundException, IOException {
        File file = new File("").getAbsoluteFile();
        FileOperations.listWordsWithOccurance(file.getPath());
    }

    @Test(expected = FileNotFoundException.class)
    public void testListWordsWithOccuranceWithInvalidFile() throws FileNotFoundException, IOException {
        File file = new File("abcd.txt").getAbsoluteFile();
        FileOperations.listWordsWithOccurance(file.getPath());
    }
}
