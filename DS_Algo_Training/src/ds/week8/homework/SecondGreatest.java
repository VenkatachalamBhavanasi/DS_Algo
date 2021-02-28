package ds.week8.homework;

import org.junit.Assert;
import org.junit.Test;

/*
Find the second greatest element in the integer array without using any additional space or sorting.
Input: [2, 1, 3, 5, 4, 11, 33, 26]
Output: 26
Input: [9, 9, 9, 9, 9]
Output: throw error
*/

/*
 * Create 2 variables to store first and second maximum value
 * iterate through each element in the array
 	* if the current element is greater than the first max
 		* set the second max as previous first max
 		* set the first max as current element
 	* if the current element is greater than second max
 		* set second max as current element
 * repeat till end of the array
 * if the first and second max are equal, then throw an error
 * else return the second max
 * 
 * Space: O[1]
 * Time: O[N]
 */
public class SecondGreatest {

	@Test
	public void example1() {
		int[] nums = { 2, 1, 3, 5, 4, 11, 33, 26 };
		Assert.assertEquals(26, findSecMax(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 9, 9, 9, 9, 9 };
		System.out.println(findSecMax(nums));
	}

	@Test
	public void example3() {
		int[] nums = { -8, -3, -11, -1, -6 };
		Assert.assertEquals(-3, findSecMax(nums));
	}

	@Test
	public void example4() {
		int[] nums = { 1 };
		System.out.println(findSecMax(nums));
	}

	private int findSecMax(int[] nums) {
		int len = nums.length;
		if (len < 2)
			throw new RuntimeException("There is no second max");

		int firstMax = Integer.MIN_VALUE, secMax = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > firstMax) {
				secMax = firstMax;
				firstMax = nums[i];
			} else if (nums[i] > secMax)
				secMax = nums[i];
		}

		if (secMax == firstMax)
			throw new RuntimeException("There is no second max");

		return secMax;
	}
}
