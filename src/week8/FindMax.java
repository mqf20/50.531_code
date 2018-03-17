package week8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMax {	
	//Precondition: the input list is a non-null list of integers
	//Postcondition: the output is the maximum integer in the list
	public static int max (int[] list) {
		int max = list[0]; 
		for (int i = 1; i < list.length-1; i++) {
			if (max < list[i]) {
				max = list[i];
			}
		}
		
		return max;		
	}
	
	@Test
	public void testError() {
		int[] list = {};
		max(list);
	}
	
	@Test
	public void testFailure() {
		int[] list = {-1, 0, 1};
		assertEquals(max(list), 1);
	}
	
	@Test
	public void testPass() {
		int[] list = {3, 2};
		assertEquals(max(list), 3);
	}
}
