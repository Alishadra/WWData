package com.workWithData.services;

import com.workWithData.entity.ConnectionEntity;

public class MyThreadService extends Thread{
	
	
	private ConnectionEntity connectionEntity;

	public MyThreadService(ConnectionEntity connectionEntity) {
		this.connectionEntity = connectionEntity;
	}
	
	@Override
	public void run() {

	FileManagerService.writeConnectionEntityToFile(connectionEntity, true);
		
	}
	
	

}
