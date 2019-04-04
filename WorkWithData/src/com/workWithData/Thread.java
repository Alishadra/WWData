package com.workWithData;

import java.io.FileWriter;
import java.io.IOException;

import com.workWithData.entity.ConnectionEntity;
import com.workWithData.services.FileManagerService;

public class Thread {


	public static void main(String[] args) throws Exception {

		FileManagerService fileManagerService = new FileManagerService();
		
		System.out.println();
		
		
		Thread writeConnectionEntityToFileThread = new WriteConnectionEntityToFileThread(fileManagerService);
		
		writeConnectionEntityToFileThread.start();
		
		writeConnectionEntityToFileThread.join();
		
		System.out.println();
		
		
		public static class WriteConnectionEntityToFileThread extends Thread {
			
			@Qverride
			public void run() {
				for (int i; i < 3; i ++) {
					
					fileManagerService.writeConnectionEntityToFile(connectionEntity, append);
					
				}
				
			}
		}
		
		

