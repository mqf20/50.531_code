package week8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BiSectionTest {
	private BiSectionExample bi;
	
	@Before 
	public void runBeforeEachTest()
	{
		bi = new BiSectionExample();
	}
	
	@Test
	public void test4MethodCoverage () {
		System.out.print(bi.root(0.5, 100.3, 0.1));
		assertTrue(bi.root(0.5, 100.3, 0.1) >= 100);
		//question: should we assert the returned value is the exact value we expect?
	}
	
	@Test 
	public void test4LoopCoverage1 () {//loop zero time
		try {
			bi.root(100,0,80);
			assertFalse(true);
		}
		catch (IllegalArgumentException e) {
			assertTrue(true);
		}	
	}
	
	@Test 
	public void test4LoopCoverage2 () {//loop once
		assertTrue(bi.root(0,100,80) > 50);
	}
}
