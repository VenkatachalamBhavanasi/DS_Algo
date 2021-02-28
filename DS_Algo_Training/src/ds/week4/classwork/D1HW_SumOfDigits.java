package ds.week4.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
Given a number, find sum of its digits.

Examples :

Input : n = 687
Output : 21

Input : n = 12
Output : 3
 */
public class D1HW_SumOfDigits {
	@Test
	public void example1() {
		int n = 687;
		Assert.assertEquals(21, sumOfDigits(n));
	}

	@Test
	public void example2() {
		int n = 12;
		Assert.assertEquals(3, sumOfDigits(n));
	}

	private int sumOfDigits(int n) {
		if (n == 0)
			return 0;
		return (n % 10 + sumOfDigits(n / 10));
	}
}
