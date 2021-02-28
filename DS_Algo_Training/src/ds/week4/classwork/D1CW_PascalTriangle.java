package ds.week4.classwork;

import org.junit.Test;

public class D1CW_PascalTriangle {
	
	@Test
	public void example1() {
		int k = 5;
		callRecursively(k);
	}
	
	private void callRecursively(int k) {
		for (int j = 1; j <= k; j++) {
			for (int i = 1; i <= j; i++) {
				System.out.print(recursion(j, i) + " ");
			}	
			System.out.println();
		}
		
	}
	
	private int recursion(int row, int column) {
		if(column == 1 || column == row)
			return 1;
		
		return recursion(row -1, column) + recursion(row -1, column-1);
		
	}
	

}
