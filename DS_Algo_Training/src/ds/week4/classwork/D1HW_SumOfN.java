package ds.week4.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
Given a number n, find sum of first n natural numbers. To calculate the sum, we will use a recursive function recur_sum().

Examples :
Input : 3
Output : 6
Explanation : 1 + 2 + 3 = 6

Input : 5
Output : 15
Explanation : 1 + 2 + 3 + 4 + 5 = 15
 */
public class D1HW_SumOfN {

	@Test
	public void example1() {
		int n = 3;
		Assert.assertEquals(6, recur_sum(n));
	}

	@Test
	public void example2() {
		int n = 5;
		Assert.assertEquals(15, recur_sum(n));
	}

	private int recur_sum(int n) {
		if (n <= 1)
			return n;
		return n + recur_sum(n - 1);
	}
}
