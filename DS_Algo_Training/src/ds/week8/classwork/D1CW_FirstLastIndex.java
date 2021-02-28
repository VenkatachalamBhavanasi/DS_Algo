package ds.week8.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
Given a sorted integer array, return the first and last occurring index of the target integer
input={11,14,19,19,19,19,19,23,24}
target=19
output=[3,5]

input={11,14,17,18,19,20,23,24}
target=19
output=[4,4]

input={11,14,17,18,19,20,23,24}
target=16
output=[-1,-1]
*/

public class D1CW_FirstLastIndex {

	@Test
	public void test1() {
		int[] numbers = {11,14,19,19,19,19,19,23,24};
		int k = 19;
		int[] twoPointer = solutionUsingBinarySearch(numbers, k);
		System.out.println(Arrays.toString(twoPointer));
	}
	
	@Test
	public void test2() {
		int[] numbers = {11,14,19,19,19,19,19,23,24};
		int k = 23;
		int[] twoPointer = solutionUsingBinarySearch(numbers, k);
		System.out.println(Arrays.toString(twoPointer));
	}
	
	@Test
	public void test3() {
		int[] numbers = {11,14,19,19,19,19,19,23,24};
		int k = 28;
		int[] twoPointer = solutionUsingBinarySearch(numbers, k);
		System.out.println(Arrays.toString(twoPointer));
	}
	
	@Test
	public void test4() {
		int[] numbers = {11,14,19,19,19,19,19,23,11};
		int k = 11;
		int[] twoPointer = solutionUsingBinarySearch(numbers, k);
		System.out.println(Arrays.toString(twoPointer));
	}
	
	@Test
	public void test5() {
		int[] numbers = {11,14,17,18,19,20,23,24,24,24};
		int k = 24;
		int[] twoPointer = solutionUsingBinarySearch(numbers, k);
		System.out.println(Arrays.toString(twoPointer));
	}
	/*
	 * Psuedocode
	 * Initialize the left and right with default value -1, -1
	 * Traverse through the loop from left to right
	 * Keep validating the left index for the k value, if found -> set the left index with current
	 * Keep validating the right index for the k, if found -> set the right index (n-1-current)
	 * Return the indicies
	 */

	// Time -> O(n)
	// Space -> O(1)
	private int[] twoPointer(int[] numbers, int k) {
		int left=-1, right =-1, n = numbers.length;
		for (int i = 0; i < n; i++) {
			if(numbers[i] == k && left == -1)
				left = i;
			if(numbers[n-1-i] == k && right == -1)
				right = n-1-i;
			if(left != -1 && right != -1)
				break;
		}
		return new int[] {left,right};
	}
	
	// Binary Search -> Only when it is sorted ?? Yes !!
	// Time Complexity : O(logn)
	// Mid Point, Decide to go left or right until you found the mid => data !!
	// Mid = (Left + Right)/2
	// Time -> O(logn)
	private int[] solutionUsingBinarySearch(int[] numbers, int k) {
		int[] output = new int[] {-1,-1};
		
		int left = binarySearch(numbers, k, true);
		if(numbers[left] != k)
			return output;
		
		int right = binarySearch(numbers, k, false);
		if(numbers[right] != k)
			right--;
		
		return new int[] {left,right};
	}
	
	private int binarySearch(int[] numbers, int k, boolean left) {
		int lo = 0, hi = numbers.length-1;
		while(lo < hi) {
			int mid = (lo+hi)/2;
			if(numbers[mid] > k ||(left && k == numbers[mid])) {
				hi = mid;
			} else {
				lo = mid+1;
			}
		}
		return lo;
	}	
}
