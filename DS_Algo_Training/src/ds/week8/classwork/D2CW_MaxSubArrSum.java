package ds.week8.classwork;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/*
Find maximum subarray sum
Input: [ 1, -5, 2, -3, 7, 1]
Output: 8
*/

public class D2CW_MaxSubArrSum {

	@Test
	public void example1() {
		int[] arr = { 1, -5, 2, -3, 7, 1 };
		Assert.assertEquals(8, greedyApproach(arr));
	}

	@Test
	public void example2() {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Assert.assertEquals(6, greedyApproach(arr));
	}

	@Test
	public void example3() {
		int[] arr = { -2, -1, -5, -3 };
		Assert.assertEquals(-1, greedyApproach(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 1, 2, 3, 4, 11 };
		Assert.assertEquals(21, greedyApproach(arr));
	}
	
	public int greedyApproach(int[] arr) {
		int sum=arr[0];
		int winSum=arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			winSum=Math.max(winSum+arr[i], arr[i]);
			sum=Math.max(sum, winSum);
		}
		
		return sum;
	}
	
	// Kandane algorithm
	/*
	 * create a variable for sum keep adding the element with the sum 
	 * if the sum goes below 0, then make the sum as 0 
	 * if sum greater than 0, add next element
	 * parallelly, we'll find the max return the max value found
	 * 
	 * Space: O[1] Time: O[N]
	 */

	public int maxSubArray(int[] arr) {
		// 1, -5, 2, -3, 7, 1
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int each : arr) {
			sum += each;

			maxSum = Math.max(sum, maxSum);

			if (sum < 0)
				sum = 0;

		}

		return maxSum;
	}

	private int findMaxSubarrSum(int[] arr) {
		return divide(arr, 0, arr.length - 1);
	}

	private int divide(int[] arr, int left, int right) {
		if (left == right)
			return arr[left];

		int mid = (left + right) / 2;

		return Math.max(divide(arr, left, mid), Math.max(divide(arr, mid + 1, right), conquer(arr, left, mid, right)));
	}

	private int conquer(int[] arr, int left, int mid, int right) {
		int leftsum = 0;
		int leftmax = Integer.MIN_VALUE;
		for (int i = mid; i >= left; i--) {
			leftsum += arr[i];
			leftmax = Math.max(leftmax, leftsum);
		}

		int rightsum = 0;
		int rightmax = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= right; i++) {
			rightsum += arr[i];
			rightmax = Math.max(rightmax, rightsum);
		}

		return leftmax + rightmax;
	}
}
