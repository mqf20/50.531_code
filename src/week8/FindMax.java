package week8;
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
}
