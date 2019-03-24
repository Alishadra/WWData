package com.workWithData;

import com.workWithData.utils.Randomizer;

public class AppRunner {


	public static void main(String[] args) {
		
		
		
		String IP = Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255);
		
		
		int ID = Randomizer.getNumberInRange(10_000_000, 100_000_000);
		

		
	}
	
}
