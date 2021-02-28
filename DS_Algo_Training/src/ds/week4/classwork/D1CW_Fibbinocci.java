package ds.week4.classwork;

import org.junit.Test;

public class D1CW_Fibbinocci {
	
	// 0 1 1 2 3 5 8 13 21 34
	// 0 1 => 1
	// 1 1 => 2
	// 1 2 => 3
	
	@Test
	public void example1() {
		int k = 8;
		//bruteForce(k);
		recursion(k);
	}
	
	private void recursion(int k) {
		//for (int i = 0; i < k; i++) {
			System.out.println(fibUsingRecursion(k));
		//}
	}
	
	private int fibUsingRecursion(int k) {
	
		if(k == 0)
			return 0;
		if(k == 1) 
			return 1;
		return fibUsingRecursion(k-1) + fibUsingRecursion(k-2);
		
	}

	private void bruteForce(int k) {
		int prev = 0;
		int next = 1;
		
		for (int i = 0; i < k; i++) {
			System.out.println(prev);
			int temp = prev + next;
			prev = next;
			next = temp;
		}
		
	}

}
