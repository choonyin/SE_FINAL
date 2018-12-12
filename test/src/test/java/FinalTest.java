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
	
	@Test
	public void FIFOShouldReturnExpectedNumber() {
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("1"); bay.add("2"); bay.add("5"); 
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("5");
		assertEquals(9, Memory_Management.FIFO(bay, frame));
	}
	
	@Test
	public void LRUShouldReturnExpectedNumber() {
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("1"); bay.add("2"); bay.add("5"); 
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("5");
		assertEquals(10, Memory_Management.LRU(bay, frame));
	}
	
	@Test
	public void OptimalShouldReturnExpectedNumber() {
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("1"); bay.add("2"); bay.add("5"); 
		bay.add("1"); bay.add("2"); bay.add("3"); bay.add("4"); bay.add("5");
		assertEquals(7, Memory_Management.Optimal(bay, frame));
	}
	
}
