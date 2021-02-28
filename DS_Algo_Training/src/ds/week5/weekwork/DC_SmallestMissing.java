package ds.week5.weekwork;

import org.junit.Assert;
import org.junit.Test;

/*
Find the smallest missing integer in the sorted array 
int[] numbers = {1,2,3,4,5,7,8,9};
output: 6
*/
//Assumption
/*
 * array will start from 1 and end with n
 * there is no duplicates in the array
 */

public class DC_SmallestMissing {

	@Test
	public void example1() {
		//left=0
		//right=8
		//mid=4
		//nums[4]=5
		//4+1==nums[4]
		int[] nums = { 1, 2, 3, 4, 5, 7, 8, 9 };
		Assert.assertEquals(6, findSmallestMissing(nums));
	}

	@Test
	public void example2() {
		
		//left=0
				//right=2
				//mid=1
				//nums[1]=3
				//1+1!=nums[1]
		int[] nums = { 1, 3, 4 };
		Assert.assertEquals(2, findSmallestMissing(nums));
	}

	@Test
	public void example3() {
		int[] nums = { 1, 2, 5, 6, 9 };
		Assert.assertEquals(3, findSmallestMissing(nums));
	}

	@Test
	public void example4() {
		int[] nums = {};
		//findSmallestMissing(nums);
		Assert.assertEquals(-1, findSmallestMissing(nums));
	}

	@Test
	public void example5() {
		int[] nums = { 1, 2, 3, 4 };
		//findSmallestMissing(nums);
		Assert.assertEquals(-1, findSmallestMissing(nums));
	}
	
	// mid, left and right
	//Pseudo code
	/*
	 * call a recursive function and pass parameters -> left and right 
	 * find the mid of the array
	 * if the left has any missing integers, traverse to the left and find the least missing integer
	 * else traverse to right to find least missing integer
	 * finally return the least missing number
	 */
	
	//Space: O[1]
	//Time: O[N]
	private int findSmallestMissing(int[] nums) {
		if(nums.length==0 || nums[nums.length-1]==nums.length)
			return -1;
	
		return helperFunc(nums, 0, nums.length-1);
	}

	private int helperFunc(int[] nums, int left, int right) {
		if(left<right) {
			int mid=(left+right)/2;
			if(nums[mid]!=mid+nums[0])
				return helperFunc(nums, left, mid);
			else
				return helperFunc(nums, mid+1, right);
		}
		
		return left+nums[0];
	}
}
