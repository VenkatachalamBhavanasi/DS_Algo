package ds.week1.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array of random numbers, Push all the zero’s of a given array to the end of the array. The order of all other elements should be same.

Example:
Input :  arr = [1, 2, 0, 4, 3, 0, 5, 0]
Output : arr = [1, 2, 4, 3, 5, 0, 0]

Input : arr = [1, 2, 0, 0, 0, 3, 6]
Output : arr = [1, 2, 3, 6, 0, 0, 0]
 */
public class D1HW_MoveZeros {
	@Test
	public void example1() {
		int[] nums = { 1, 2, 0, 4, 3, 0, 5, 0 };
		moveZeros(nums);
		moveZerosOptimized(nums);
		twoPointer(nums);
		twoPointerMaintainOrder(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 0, 0, 0, 3, 6 };
		moveZeros(nums);
		moveZerosOptimized(nums);
		twoPointer(nums);
		twoPointerMaintainOrder(nums);
	}

	private void moveZeros(int[] nums) {
		int[] output = new int[nums.length];
		int ind = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != 0)
				output[ind++] = nums[i];

		System.out.println(Arrays.toString(output));
	}

	private void moveZerosOptimized(int[] nums) {
		int ind = 0;

		for (int i = 0; i < nums.length; i++)
			if (nums[i] != 0)
				nums[ind++] = nums[i];

		while (ind < nums.length)
			nums[ind++] = 0;

		System.out.println(Arrays.toString(nums));
	}

	private void twoPointer(int[] nums) {
		int zero = 0, nonZero = 0;

		while (nonZero < nums.length) {
			if (nums[nonZero] != 0) {
				int temp = nums[zero];
				nums[zero++] = nums[nonZero];
				nums[nonZero++] = temp;
			} else
				nonZero++;
		}

		System.out.println(Arrays.toString(nums));
	}

	private void twoPointerMaintainOrder(int[] nums) {
		int[] output = new int[nums.length];
		int left = 0, right = nums.length - 1;
		int lInd = 0, rInd = nums.length - 1;
		// while(left<nums.length || right>=0) 
		while (left < nums.length) {
			if (nums[left] != 0)
				output[lInd++] = nums[left];
			// if(nums[right]==0)
			// output[rInd--]=nums[right];

			left++;
			// right--;
		}
		System.out.println(Arrays.toString(output));
	}
}
