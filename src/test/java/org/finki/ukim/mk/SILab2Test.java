package org.finki.ukim.mk;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

	final List<String> defaultCase = Arrays.asList(
			"#", "0", "#", "0",
			"0", "#", "0", "0",
			"0", "#", "#", "0",
			"0", "0", "0", "0"
	);

	final List<String> expectedResultDefaultCase = Arrays.asList(
			"#", "3", "#", "1",
			"2", "#", "3", "0",
			"1", "#", "#", "1",
			"0", "1", "1", "0"
	);

	@Test
	void testEveryStatementCriteria() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(new ArrayList<>()));
		assertTrue(ex.getMessage().equalsIgnoreCase("List length should be greater than 0"));

		ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(Arrays.asList("0", "0")));
		assertTrue(ex.getMessage().equalsIgnoreCase("List length should be a perfect square"));

		assertEquals(expectedResultDefaultCase, SILab2.function(defaultCase));
	}


	@Test
	void testEveryBranchCriteria() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(new ArrayList<>()));
		assertTrue(ex.getMessage().equalsIgnoreCase("List length should be greater than 0"));

		ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(Arrays.asList("0", "0")));
		assertTrue(ex.getMessage().equalsIgnoreCase("List length should be a perfect square"));

		assertEquals(expectedResultDefaultCase, SILab2.function(defaultCase));
	}

}
