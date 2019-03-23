import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.workWithData.Entity.ConnectionEntity;

import ua.com.qalight.service.FileManagerService;

class FileManagerServiceTest {
	
	private static List<ConnectionEntity> connectionLogsInFile;

	@Test
	void testWriteObjectToFile() {
		
	}
	
	@Test
	void testReadObjectFromFile() {
		
	}
	
	@BeforeAll
	public static void saveDataFromFile() {
		connectionLogsInFile = FileManagerService.readConnectionLogsFromFile();
	}
	
	@Test
	void testWriteAndReadConnectionLogInFile() {
		
	}
	
	

}
