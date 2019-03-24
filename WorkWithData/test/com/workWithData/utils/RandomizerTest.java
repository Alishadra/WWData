package com.workWithData.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomizerTest {

	@Test
	void testGetNumberInRange() {

		int result = Randomizer.getNumberInRange(7, 15);
		
		assertTrue(result >=7 && result <= 15);
	}

}
