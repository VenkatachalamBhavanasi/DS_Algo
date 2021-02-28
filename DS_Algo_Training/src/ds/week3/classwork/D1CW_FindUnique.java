package ds.week3.classwork;

import java.util.HashSet;

import org.junit.Test;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
*/

public class D1CW_FindUnique {
	/*
	 * Add every data to the Set
	 * If the set has it already then remove it
	 * Finally, you will find the single data
	 * 
	 */

	// Time O(n)
	// Space O(n)
	private int findSingleUsingHashSet(int[] data) {
		HashSet<Integer> single = new HashSet<>();
		for (int i = 0; i < data.length; i++) {
			if (!single.add(data[i]))
				single.remove(data[i]);
		}
		return single.iterator().next();
	}

	// 2 2 1 1 XOR
	// Time: O(n)
	// Space: O(1)
	private int findSingle(int[] data) {
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			result ^= data[i];
		}
		return result;
	}

	@Test
	public void example1() {
		int[] data = { 2, 2, 1 };
		int num = findSingle(data);
		System.out.println(num);
	}

	@Test
	public void example2() {
		int[] data = { 4, 1, 2, 1, 2 };
		int num = findSingle(data);
		System.out.println(num);
	}

	@Test
	public void example3() {
		int[] data = { 1 };
		int num = findSingle(data);
		System.out.println(num);
	}
}
