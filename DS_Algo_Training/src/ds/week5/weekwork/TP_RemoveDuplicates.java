package ds.week5.weekwork;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3]
Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3]
Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.
*/

public class TP_RemoveDuplicates {

	@Test
	public void example1() {
		int[] nums= {1,1,1,2,2,3};
		Assert.assertEquals(5, removeDuplicates(nums));
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 5)));
	}
	
	@Test
	public void example2() {
		int[] nums= {0,0,1,1,1,1,2,3,3};
		Assert.assertEquals(7, removeDuplicates(nums));
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 7)));
	}
	
	public int removeDuplicates(int[] nums) {
        int ind=1,dup=0;
        for (int i = 1; i < nums.length; i++) {
			if(nums[i-1]==nums[i])
				dup++;
			else
				dup=0;
			if(dup<=1)
				nums[ind++]=nums[i];
		}
        return ind;
    }
}
