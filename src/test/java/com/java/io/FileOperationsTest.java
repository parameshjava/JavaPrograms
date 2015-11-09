package com.java.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FileOperationsTest {

	@Test
	public void testListWordsWithOccurance() throws FileNotFoundException, IOException {
		File file = new File("src/test/resources/test_file.txt").getAbsoluteFile();
		Map<String, Integer> wordsMap = FileOperations.listWordsWithOccurance(file.getPath());
		assertNotNull(wordsMap);
	}

	@Test
	public void testFilterMaxOccurance() {
		Map<String, Integer> wordsMap = new HashMap<>();
		wordsMap.put("Rahul", 15);
		wordsMap.put("Ranjith", 12);
		wordsMap.put("Aruna", 10);
		List<String> words = FileOperations.filterMaxOccurance(wordsMap, 3);
		assertNotNull(words);
	}

}
