package week8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RussianTest {
	
	@Test
	public void testBlackBox1() {
		assertEquals(4, Russian.multiply(2, 2));
	}
	
	@Test
	public void testBlackBox2() {
		assertEquals(0, Russian.multiply(2, 0));
	}

	@Test
	public void testBlackBox3() {
		assertEquals(10, Russian.multiply(-2, -5));
	}

	@Test
	public void testWhiteBox1() {
		assertEquals(0, Russian.multiply(5, 0));  // don't enter while loop
	}
	
	@Test
	public void testWhiteBox2() {
		assertEquals(5, Russian.multiply(5, 2));  // enter while loop
	}
	
	@Test
	public void testFault1() {
		assertEquals(2147483647L*2, Russian.multiply(2147483647, 2));
	}

}