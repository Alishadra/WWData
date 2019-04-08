package com.workWithData;

import com.workWithData.entity.ConnectionEntity;
import com.workWithData.services.MyMainThread;
import com.workWithData.utils.Randomizer;

public class AppRunner {


	public static void main(String[] args) {
		
		for (int i = 0; i < 3; i++) {
			
			MyMainThread mainThread = new MyMainThread();
			
			mainThread.start();
			
		}
		
		

		
	}
	
}
