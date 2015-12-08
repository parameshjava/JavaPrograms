package com.java.loops;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MultiplicationTableTest {

	@Test
	public void testPrintMul() {
		String table = MultiplicationTable.generateMultiplicationTable(10);
		assertNotNull(table);
		String[] rows = table.split("\n");
		System.out.println(table);
		assertThat(12, is(rows.length)); // One header row + One dots (---) row + 10 rows 
		
		assertTrue(rows[0].contains("   * |   1   2   3   4   5   6   7   8   9  10"));
		assertTrue(rows[1].contains("----------------------------------------------"));
		assertTrue(rows[2].contains("   1 |   1   2   3   4   5   6   7   8   9  10"));
		assertTrue(rows[3].contains("   2 |   2   4   6   8  10  12  14  16  18  20"));
		assertTrue(rows[4].contains("   3 |   3   6   9  12  15  18  21  24  27  30"));
		assertTrue(rows[5].contains("   4 |   4   8  12  16  20  24  28  32  36  40"));
		assertTrue(rows[6].contains("   5 |   5  10  15  20  25  30  35  40  45  50"));
		assertTrue(rows[7].contains("   6 |   6  12  18  24  30  36  42  48  54  60"));
		assertTrue(rows[8].contains("   7 |   7  14  21  28  35  42  49  56  63  70"));
		assertTrue(rows[9].contains("   8 |   8  16  24  32  40  48  56  64  72  80"));
		assertTrue(rows[10].contains("   9 |   9  18  27  36  45  54  63  72  81  90"));
		assertTrue(rows[11].contains("  10 |  10  20  30  40  50  60  70  80  90 100"));
		
	}

}
