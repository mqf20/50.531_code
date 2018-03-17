package week8;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class QuickSortTest {

	public int[] list;
	public static final int NUM_TESTS = 100, MAX_LENGTH = 100;

	public QuickSortTest(int[] list) {
		this.list = list;
	}

	@Parameters
	public static Collection<Object[]> parameters() {

		Object[][] objects = new Object[NUM_TESTS][1];
		Random random = new Random(); int[] list; int length;

		for (int i = 0; i < NUM_TESTS; i++) {
			length = random.nextInt(MAX_LENGTH-2) + 2;
			list = new int[length];
			for (int j = 0; j < length; j++) {
				list[j] = random.nextInt();
			}
			objects[i][0] = list;
		}
		
		return Arrays.asList(objects);
	}
	
	@Test
	public void unitTest() {
		new QuickSort().sort(list);
		assertTrue(inOrder(list));
	}
	
	public boolean inOrder(int[] list) {
		int prev = list[0]; int next;
		for (int i = 1; i < list.length; i++) {
			next = list[i];
			if (prev > next) {
				return false;
			}
			prev = next;
		}
		return true;
	}

}