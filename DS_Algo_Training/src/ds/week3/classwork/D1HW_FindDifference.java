package ds.week3.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/*
 Given an array of integers and an integer k, 
 find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

public class D1HW_FindDifference {

	@Test
	public void example1() {
		int[] nums= {1,2,3,1};
		int k=3;
		System.out.println(isDifferenceAtmostK(nums, k));
	}
	
	@Test
	public void example2() {
		int[] nums= {1,2,3,1,2,3};
		int k=2;
		System.out.println(isDifferenceAtmostK(nums, k));
	}
	
	@Test
	public void example3() {
		int[] nums= {1,1};
		int k=2;
		System.out.println(isDifferenceAtmostK(nums, k));
	}
	
	@Test
	public void example4() {
		int[] nums= {1,2,3,1,1,3};
		int k=2;
		System.out.println(isDifferenceAtmostK(nums, k));
	}
	
	//Pseudo Code
	/*
	 * Create a new map with each element as key and its corresponding index as value
	 * check whether the element is present in the map,
	 * if present, get its index and find the difference between current index and element previous index
	 * if the difference is less than or equal to k then return true
	 * if not, update the key value with current index
	 * if the element is unique add it to the map with its corresponding index
	 */
	
	private boolean isDifferenceAtmostK(int[] nums,int k) {
		Map<Integer, Integer> map=new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				System.out.println(i-map.get(nums[i]));
				if(i-map.get(nums[i])<=k)
					return true;
				else
					map.put(nums[i], i);
			}else
				map.put(nums[i], i);
			
			System.out.println(map);
		}
		return false;
	}
}
