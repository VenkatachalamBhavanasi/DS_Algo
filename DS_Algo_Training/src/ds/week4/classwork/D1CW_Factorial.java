package ds.week4.classwork;

import org.junit.Test;

public class D1CW_Factorial {
	// 5! = 5 x 4 x 3 x 2 x 1 = 120 (n * n-1)
	
	@Test
	public void example1() {
		int k = 5;
		//bruteForce(k);
		System.out.println(recursive(k));
	}
	
	private void bruteForce(int k) {
		int fact = 1;
		for (int i = k; i > 0; i--) {
			fact = fact * i;
		}
		System.out.println(fact);
	}
	
	private int recursive(int k) {
		if(k == 1)
			return 1;
		int n = k * recursive(k-1);
		return n;
	}
	
	

}
