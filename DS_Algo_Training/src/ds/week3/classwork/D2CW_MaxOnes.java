package ds.week3.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
*/

public class D2CW_MaxOnes {

	@Test
	public void test1() {		
		int[] numbers = {1,1,1,0,0,1,1,1,1,1,0};
		int k = 2; // 0 -> 1 -> 2-1 -> 1 -> 0
		int count = longestOnes(numbers, k);
		System.out.println(count);
	}

	@Test
	public void test2() {		
		int[] numbers = {1,0,1,0,1,0,0,0,1,1,0};
		int k = 2;
		int count = longestOnes(numbers, k);
		System.out.println(count);

	}

	/*
	 * Approach: Sliding Window 
	 * - Continuous Array (Adjacent Element)
	 * - Target (k)
	 * - O(n)
	 * 
	 * Psuedo Code:
	 * 1) Create 2 pointers (left, right) and travel in equi
	 * 2) Traverse the given array from left -> right
	 * 3) Move Right alone 
	 * 4) If it is zero, deduct 1 from k
	 * 5) Keep doing 3-4
	 * 6) When K becomes negative (We consumed all the flips and we cannot consume anymore)
	 * 		a) Move your left towards right 
	 * 		b) When the value of left from where you moved is zero, then increment k
	 * 		c) If it is zero or one, increment the left
	 * 7) Finally, return the right - left 
	 */
	
	public int longestOnes(int[] numbers, int k) {
		
		int left = 0, right;
		
		for (right = 0; right < numbers.length; right++) {
			if(numbers[right] == 0)
				k--;
			
			if(k < 0) {
				if(numbers[left] == 0)
					k++;
				left++;
			}
		}
		return right - left;
	}
}
