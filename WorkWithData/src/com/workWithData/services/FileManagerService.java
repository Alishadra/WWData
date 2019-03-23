package com.workWithData.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import com.workWithData.Entity.ConnectionEntity;

import ua.com.qalight.entity.ConnectionLog;

public class FileManagerService {

	private static final String TEXT_FILE_PATH =
						 System.getProperty("user.dir")+
						 System.getProperty("file.separator")+
						 "files" + 
						 System.getProperty("file.separator")+
						 "file.txt";
	
	public static void writeConnectionEntityToFile(ConnectionEntity connectionEntity, boolean append) {
		
		try (FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append)){
			fileWriter.write(connectionEntity.toString() + "\n");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		public static List<ConnectionEntity> readConnectionEntityFromFile() {
			
			List<ConnectionEntity> connectionEntitys = new ArrayList<ConnectionEntity>();
			
			try (FileReader fileReader = new FileReader(TEXT_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			
				String line = "";
				while((line = bufferedReader.readLine()) != null) {
					
					String[] words = line.split(" ");
					long time = Long.parseLong(words[0]);
					int sessionId = Integer.parseInt(words[1]);
					String ip = words[2];
					
					ConnectionEntity conectionEntity = new ConnectionEntity(time, sessionId, ip);
					conectionEntity.add(conectionEntity);
					
				}
				
			} catch (Exception e) {
			}
			
		}
		
	}
			
}
