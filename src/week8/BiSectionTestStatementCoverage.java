package week8;

import org.junit.Test;

public class BiSectionTestStatementCoverage {
	
	@Test(expected = IllegalArgumentException.class)
	public void test4StatementCoverage1() {
		new BiSectionExample().root(2.0, 1.0, 0.5);
	}
	
	@Test
	public void test4StatementCoverage2() {
		new BiSectionExample().root(5.0, 10.0, 1.0);
	}

	@Test
	public void test4StatementCoverage3() {
		new BiSectionExample().root(5.0, 10.0, 0);
	}

}
