package ds.week8.homework;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true
*/

/*
 * create 2 boolean variables, one for increasing and one for decreasing
 * iterate through each element in the array
 	* iterate each element and check if it is keeps increasing until it reaches the peak poing
 	* Once it reached the peak point, check if the array values keeps decreasing
 	* if there is any duplicate in the array, return false
 * after iterating through all elements in the array, check if both the boolean are true
 	* if yes, return true else return false 
 * 
 * Space: O[1]
 * Time: O[N]
 */

public class MountainArray {

	@Test
	public void example1() {
		int[] arr = { 2, 1 };
		Assert.assertEquals(false, isMountainArray(arr));
	}

	@Test
	public void example2() {
		int[] arr = { 0, 3, 2, 1 };
		Assert.assertEquals(true, isMountainArray(arr));
	}

	@Test
	public void example3() {
		int[] arr = { 3, 5, 5 };
		Assert.assertEquals(false, isMountainArray(arr));
	}

	@Test
	public void example4() {
		int[] arr = { 2, 2, 2 };
		Assert.assertEquals(false, isMountainArray(arr));
	}

	@Test
	public void example5() {
		int[] arr = { 0, 1, 2, 3, 4 };
		Assert.assertEquals(false, isMountainArray(arr));
	}

	@Test
	public void example6() {
		int[] arr = { 5, 4, 3, 4, 5 };
		Assert.assertEquals(false, isMountainArray(arr));
	}

	private boolean isMountainArray(int[] arr) {
		if(arr.length<3)
			return false;
		
		boolean inc = false, dec = false;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1] && !dec)
				inc = true;
			else if (arr[i] > arr[i + 1])
				dec = true;
			else
				return false;
		}

		if (!inc || !dec)
			return false;

		return true;
	}
}
