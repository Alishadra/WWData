package com.workWithData.utils;

import java.util.Random;

public class Randomizer {
	
	public static int getNumberInRange(int min, int max) {
		
		Random random = new Random();
		return min + random.nextInt();
		
		
	}

}
