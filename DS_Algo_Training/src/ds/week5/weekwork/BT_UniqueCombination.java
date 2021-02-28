package ds.week5.weekwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Example,
Given candidate set 2,3,6,7,1 and target 7,
A solution set is:
[2, 2, 3]
[3,3,1]
[2,2,2,1]
[7]
[1,1,1,1,1,1,1]
*/

public class BT_UniqueCombination {

	@Test
	public void example1() {
		int[] nums = { 2, 3, 6, 7, 1 };
		int target = 7;
		findCombinations(nums, target);
	}

	@Test
	public void example2() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 6;
		findCombinations(nums, target);
	}
	
	@Test
	public void example3() {
		int[] nums = { 2 };
		int target = 15;
		findCombinations(nums, target);
		//[]
	}
	
	@Test
	public void example4() {
		int[] nums = { 20 };
		int target = 2;
		findCombinations(nums, target);
		//[]
	}
	
	//Pseudo code
	/*
	 * initialize a List to store the subset
	 * call the recursive function
	 	* keep adding the current index element to the list (temp) and also keep track of the subset sum
	 	* if the subset sum equals target, i'll add it to the output list
	 	* if the subset sum is greater than target, then backtrack (i'll remove the last element from the temp list) it and add next element in to the temp list
	 * finally return/print the output list 
	 */
	//Space: O[N]
	//Time: O[N]
	private void findCombinations(int[] nums, int target) {
		List<List<Integer>> output=new ArrayList<>();
		helperFunc(nums, target, output, new ArrayList<>(), 0,0);
		System.out.println(output);
	}

	private void helperFunc(int[] nums, int target, List<List<Integer>> output, List<Integer> temp, int start, int sum) {
		if(sum==target) {
			output.add(new ArrayList<>(temp));
			return;
		}
		
		if(sum>target)
			return;
			
		for (int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			sum+=nums[i];
			helperFunc(nums, target, output, temp, i, sum);
			sum-=nums[i];
			temp.remove(temp.size()-1);
		}
	}
}
