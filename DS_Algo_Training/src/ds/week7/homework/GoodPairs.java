package ds.week7.homework;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
*/

public class GoodPairs {

	@Test
	public void example1() {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		Assert.assertEquals(4, findGoodPairs(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 1, 1, 1 };
		Assert.assertEquals(6, findGoodPairs(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 3 };
		Assert.assertEquals(0, findGoodPairs(nums));
	}

	private int findGoodPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int res = 0;
		for (Map.Entry<Integer, Integer> en : map.entrySet()) {
			if (en.getValue() > 1) {
				res += en.getValue() * (en.getValue() - 1) / 2;
			}
		}
		return res;
	}
}
