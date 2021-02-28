package ds.week8.homework;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array nums of n integers where n > 1,  
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array 
(including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).
*/

public class ProductOfArray {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 4 };
		prdctOfArray(nums);
	}

	private void prdctOfArray(int[] nums) {
		int len = nums.length;
		int[] output = new int[len];
		output[0] = 1;
		for (int i = 1; i < len; i++) {
			output[i] = nums[i - 1] * output[i - 1];
		}

		int prev = nums[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			output[i]*=prev;
			prev*=nums[i];
		}

		System.out.println(Arrays.toString(output));
	}
}
