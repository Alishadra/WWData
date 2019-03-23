import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.workWithData.utils.Randomizer;

class RandomizeTest {

	@Test
	void testGetNumberInRange() {

	int result = Randomizer.getNumberInRange(7,15);
	
	assertTrue(result >= 7 && result <= 15);
	}

}
