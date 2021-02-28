package ds.week8.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/*
Given an array of int, print leader set
Note: when numbers on right side are less than current element are considered for leader set 
 Input=[3,4,2,7,1,2,4,5]
 Output=[7,5]
 Explanation:
 [7] -> [1,2,4,5] are less than 7
 [5] -> No elements available to right side
 
 Input=[4,9,3,5,6,5,2]
 Output=[9,6,5,2]
 
 Input=[2,1]
 Output=[2,1]
*/

public class LeaderSet {

	@Test
	public void example1() {
		int[] nums = { 4, 9, 3, 5, 6, 5, 2 };
		findLeaderSet(nums);
	}

	@Test
	public void example2() {
		int[] nums = { 3, 4, 2, 7, 1, 2, 4, 5 };
		findLeaderSet(nums);
	}

	@Test
	public void example3() {
		int[] nums = { 2, 1 };
		findLeaderSet(nums);
	}

	private void findLeaderSet(int[] nums) {
		int len = nums.length;
		int max = nums[len - 1];
		List<Integer> output = new ArrayList<>();
		output.add(max);

		for (int i = len - 2; i >= 0; i--) {
			if (nums[i] > max) {
				output.add(nums[i]);
				max = nums[i];
			}
		}

		System.out.println(output);
	}
}
