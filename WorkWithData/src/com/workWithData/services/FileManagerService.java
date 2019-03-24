package com.workWithData.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.workWithData.entity.ConnectionEntity;

import ua.com.qalight.entity.ConnectionLog;
import ua.com.qalight.service.FileManagerService;

public class FileManagerService {

	private static final String TEXT_FILE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "files" + System.getProperty("file.separator") + "file.txt";

	public static void writeConnectionEntityToFile(ConnectionEntity connectionEntity, boolean append) {

		try (FileWriter fileWriter = new FileWriter(TEXT_FILE_PATH, append)) {

			fileWriter.write(connectionEntity.toString() + "\n");
			fileWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<ConnectionEntity> readConnectionEntityFromFile() {

		List<ConnectionEntity> connectionEntities = new ArrayList<ConnectionEntity>();

		try (FileReader fileReader = new FileReader(TEXT_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			String line = "";
			while ((line = bufferedReader.readLine()) != null) {

				String[] words = line.split(" ");
				long time = Long.parseLong(words[0]);
				int sessionId = Integer.parseInt(words[1]);
				String ip = words[2];

				ConnectionEntity conectionEntity = new ConnectionEntity(time, sessionId, ip);
				connectionEntities.add(conectionEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connectionEntities;
	}
	
	public static void filterConnectionLogFileByTime(int days) {
		long marginTime = System.currentTimeMillis() - (1000*60*60*24*days);
		List<ConnectionEntity> connectionLogs = readConnectionEntityFromFile();
		boolean append = false;
		for (ConnectionEntity connectionEntity : connectionEntities) {
			if(connectionEntity.getTime() > marginTime) {
				FileManagerService.writeConnectionEntityToFile(connectionEntity, append);
				append = true;
			}
		}
	}

}
