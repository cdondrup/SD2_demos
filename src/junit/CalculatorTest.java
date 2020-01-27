package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
//	private static Calculator c;
//	
//	@BeforeAll
//	static void setUp() {
//		c = new Calculator();
//	}

	@Test
	void testSum() {
		assertEquals(8, Calculator.sum(5, 3), "Testing sum 5 + 3");
	}
	
	@Test
	void testNotSum() {
		assertNotEquals(1, Calculator.sum(5, 3), "Testing sum 5 + 3");
	}

}
