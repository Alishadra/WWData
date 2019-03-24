package com.workWithData.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.workWithData.entity.ConnectionEntity;
import com.workWithData.services.FileManagerService;
import com.workWithData.utils.Randomizer;

class FileManagerServiceTest {

	private static List<ConnectionEntity> connectionEntitiesInFile;

	@Test
	void testWriteObjectToFile() {

	}

	@Test
	void testReadObjectFromFile() {

	}

	@BeforeAll
	public static void saveDataFromFile() {

		connectionEntitiesInFile = FileManagerService.readConnectionEntityFromFile();
	}

	@Test
	void testWriteAndReadConnectionLogInFile() {
		long time = System.currentTimeMillis();
		int sessionId = Randomizer.getNumberInRange(10_000_000, 100_000_000);
		String ip = Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255) + "."
				+ Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255);
		
		ConnectionEntity connectionEntity = new ConnectionEntity(time, sessionId, ip);
		FileManagerService.writeConnectionEntityToFile(connectionEntity, false);
		
		List<ConnectionEntity> connectionEntities = FileManagerService.readConnectionEntityFromFile();
		
		assertTrue(connectionEntities != null);
		assertTrue(connectionEntities.size() == 1);
		
		assertEquals(ip, connectionEntities.get(0).getIp());

	}
	
	@Test
	void testFilterByTime() {
		int sessionId = Randomizer.getNumberInRange(10_000_000, 100_000_000);
		String ip = Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255) + "."
				+ Randomizer.getNumberInRange(1, 255) + "." + Randomizer.getNumberInRange(1, 255);
		
		long timeVeryOld = System.currentTimeMillis() - (1000*60*60*24*5);
		ConnectionEntity connectionEntityVeryOld = new ConnectionEntity(timeVeryOld, sessionId, ip);
		
		long timeOld = System.currentTimeMillis() - (1000*60*60*24*3);
		ConnectionEntity connectionEntityOld = new ConnectionEntity(timeOld, sessionId, ip);
		
		long timeNow = System.currentTimeMillis();
		ConnectionEntity connectionEntityNow = new ConnectionEntity(timeNow, sessionId, ip);
		
		FileManagerService.writeConnectionEntityToFile(connectionEntityVeryOld, false);
		FileManagerService.writeConnectionEntityToFile(connectionEntityOld, true);
		FileManagerService.writeConnectionEntityToFile(connectionEntityNow, true);
		
		List<ConnectionEntity> connectionEntities = FileManagerService.readConnectionEntityFromFile();
		assertEquals(3, connectionEntities.size());
		
		FileManagerService.filterConnectionLogFileByTime(10);
		connectionEntities = FileManagerService.readConnectionEntityFromFile();
		assertEquals(2, connectionEntities.size());
		for (ConnectionEntity connectionEntity : connectionEntities) {
			assertTrue(connectionEntities.getTime() != timeOld);
			assertTrue(connectionEntities.getTime() == timeNow);
		}
		
	}
	
	@AfterAll
	public static void saveDataToFile() {
		if(connectionEntitiesInFile.isEmpty()) {
			for (int i = 0; i < connectionEntitiesInFile.size(); i ++) {
				if (i == 0) {
					FileManagerService.writeConnectionEntityToFile(connectionEntitiesInFile.get(i), false);
				} else {
					FileManagerService.writeConnectionEntityToFile(connectionEntitiesInFile.get(i), true);
				}
			}
		}
		
		
	}

}
