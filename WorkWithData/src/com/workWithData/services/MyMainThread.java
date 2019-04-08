package com.workWithData.services;

import com.workWithData.entity.ConnectionEntity;
import com.workWithData.utils.Randomizer;

public class MyMainThread extends Thread{
	
	
	
	@Override
	public void run() {

		
		for (int i = 0; i < 10; i++) {
			
			long time = System.currentTimeMillis();
			int sessionId = Randomizer.getNumberInRange(10_000_000, 100_000_000);
			String ip = Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255) + "."
					+ Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255);
			
			ConnectionEntity connectionEntity = new ConnectionEntity(time, sessionId, ip);
			
			MyThreadService service = new MyThreadService(connectionEntity);
			
			service.start();
		}
		
	}
	

}
