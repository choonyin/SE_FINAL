import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FinalTest {
	List<String> bay = new ArrayList<>();
	int frame = 3;
	
	@Test
	public void isNumericShouldWork() {
		assertTrue(Memory_Management.isNumeric("1"));
		assertFalse(Memory_Management.isNumeric("0.1"));
	}
	
}
