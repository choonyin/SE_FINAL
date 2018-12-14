import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FinalTest {
	
	@Test
	Public void isNumericShouldWork(){
		assertTrue(Memory_Management.isNumeric("1"));
		assertFalse(Memory_Management.isNumeric("a"));
	}
	
}
