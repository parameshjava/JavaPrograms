package com.java.reverse;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class StringReverseTest {

	@Test
	public void test() {
		String reverseStr1 = StringReverse.reverseRecursive("Japan");
		String reverseStr2 = StringReverse.reverseString("Japan");
		assertTrue(reverseStr1.equals(reverseStr2));
		assertThat("napaJ", is(reverseStr1));
		assertThat("napaJ", is(reverseStr2));
		
		String reverseSingleChar1 = StringReverse.reverseRecursive("J");
		String reverseSingleChar2 = StringReverse.reverseString("J");
		assertThat("J", is(reverseSingleChar1));
		assertThat("J", is(reverseSingleChar2));
	}

}
