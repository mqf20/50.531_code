package week8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BlackBoxTestExampleTest {
	@Test
	public void testBlack1() {
		assertTrue(BlackBoxTestExample.isDateString("2014/09/09"));
	}

	@Test
	public void testBlack2() {
		assertFalse(BlackBoxTestExample.isDateString("2014/009"));
	}
}
