package ds.week8.classwork;

import java.util.Arrays;
import java.util.HashSet;

import javax.management.RuntimeErrorException;

import org.junit.Test;

/*
Given an array of integers and an integer k, find out whether there are two 
distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
Example 3:
Input: nums = [1,2,3,2,2,3], k = 2
Output: true
*/

public class D2CW_MinimumDistance {
	
	@Test
	public void test1() {
		int[] numbers = {1,2,3,1};
		int k = 3;
		boolean found = minimumDistance(numbers, k);
		System.out.println(found);
	}
	
	@Test
	public void test2() {
		int[] numbers = {1,2,3,1,2,3};
		int k = 2;
		boolean found = minimumDistance(numbers, k);
		System.out.println(found);
	}
	
	@Test
	public void test3() {
		int[] numbers = {1,2,3};
		int k = 4;
		boolean found = minimumDistance(numbers, k);
		System.out.println(found);
	}
	/*
	 * Loop through until first k values and store in collection
	 * 	- When duplicates found -> return true 
	 * 
	 * Loop through from k index to entire length
	 * 	- Sliding window (remove the left most index)
	 * 		- Add the new index to the collection
	 * 		- When duplicates found -> return true 
	 * 		
	 * Finally, return false
	 */
	private boolean minimumDistance(int[] numbers, int k) {
		if(k > numbers.length)
			throw new RuntimeException("Invalid k Input");
		
		HashSet<Integer> set = new HashSet<>();
		
		// First k values !!
		for (int i = 0; i <= k; i++) {
			if(!set.add(numbers[i]))
				return true;
		}
		
		// From k+1 to length
		for (int i = k+1; i < numbers.length; i++) {
			set.remove(numbers[i-1-k]);
			if(!set.add(numbers[i]))
				return true;
		}
		
		return false;
	}

}