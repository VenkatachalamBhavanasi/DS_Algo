package ds.week4.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
The Tribonacci sequence Tn is defined as follows: 
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537
*/

public class D1HW_TribonacciSeries {

	@Test
	public void example1() {
		int n = 4;
		Assert.assertEquals(4, findNthTribonacciValue(n));
	}

	@Test
	public void example2() {
		int n = 25;
		Assert.assertEquals(1389537, findNthTribonacciValue(n));
	}
	
	@Test
	public void example3() {
		int n = 10;
		Assert.assertEquals(149, findNthTribonacciValue(n));
	}
	//Space: O(1)
	//Time: more than O[N]
	private int findNthTribonacciValue(int n) {
		if(n<=0)
			return 0;
		else if(n==1 || n==2)
			return 1;
		
		/*
		 Tn+3 = Tn + Tn+1 + Tn+2
		 Tn+3= Tn + Tn+1 + Tn-1 + Tn + Tn+1
		 Tn+3= 2* Tn+1 + 2*Tn + Tn-1
		 Tn= 2*Tn-2 + 2* Tn-3 + Tn-4
		 */
		
		return 2*findNthTribonacciValue(n-2)+2*findNthTribonacciValue(n-3)+findNthTribonacciValue(n-4);
		//return findNthTribonacciValue(n-3)+findNthTribonacciValue(n-2)+findNthTribonacciValue(n-1);
	}
}
