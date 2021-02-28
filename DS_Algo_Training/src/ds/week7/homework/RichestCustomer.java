package ds.week7.homework;

import org.junit.Assert;
import org.junit.Test;

/*
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

 

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17
*/

public class RichestCustomer {

	@Test
	public void example1() {
		int[][] accounts = { { 1, 2, 3 }, { 3, 2, 1 } };
		Assert.assertEquals(6, maxWealth(accounts));
	}

	@Test
	public void example2() {
		int[][] accounts = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
		Assert.assertEquals(10, maxWealth(accounts));
	}

	@Test
	public void example3() {
		int[][] accounts = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };
		Assert.assertEquals(17, maxWealth(accounts));
	}

	private int maxWealth(int[][] accounts) {
		int maxSum = Integer.MIN_VALUE, l = 0, r = 0, sum = 0;
		for (int i = 0; i < accounts.length; i++) {
			l = 0;
			r = accounts[i].length - 1;
			sum = 0;
			while (l <= r) {
				if (l == r)
					sum += accounts[i][l++];
				else
					sum += accounts[i][l++] + accounts[i][r--];
			}
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}
}
