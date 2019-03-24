package com.workWithData;

import com.workWithData.Entity.ConnectionEntity;
import com.workWithData.services.FileManagerService;
import com.workWithData.utils.Randomizer;

public class AppRunner {


	public static void main(String[] args) {
		
	FileManagerService fileManagerServise = new FileManagerService();
		
		fileManagerServise.writeConnectionEntityToFile(conectionEntity, true);
		
		
		String IP = Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255)+"."+Randomizer.getNumberInRange(1, 255);
		
		
		int ID = Randomizer.getNumberInRange(10_000_000, 100_000_000);
		

		for (int i = 1; i<11; i++) {
		}
		
	}
	
}
