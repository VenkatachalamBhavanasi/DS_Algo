package ds.week1.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
Write a program to move all the positive numbers to end. 

Input: [4, -1, 9, 0, 2, -4, 5]
Output: [-1, 0, -4, 4, 9, 2, 5]
 */
public class MovePositive {
	/*
	 * 1) Did i understand the problem? 
	 *    Parameters
	 *      -> What is the input for this problem? 
	 *      -> What will be the output for this problem? 
	 *      -> is there any constraints? 
	 *      -> Do i have all informants to go the next step? 
	 *      -> How big is the test data?
	 *      
	 * 2) Test data set
	 *    -> Minimum of 3 data sets
	 *    -> Positive, Negative and Edge case scenario
	 *    -> Validate the test data with interviewer
	 *    
	 * 3) Do i know to solve it?
	 * 
	 * 4) Ask for hint if don't know to solve? 
	 * 
	 * 5) Do i know any alternate solution?
	 *    -> No, Solve with the known solution
	 *    
	 * 6) If alternate solution found -> Find the O notation 
	 *     -> Explain either or the best one depends on time
	 *     -> Approach 01 : Starts with worst(Brute force)
	 *     -> Approach 02: Write the options and benefits of it 
	 *     -> Always start from worst to best
	 *     
	 * 7) Proceed with pseudocode 
	 * 
	 * 8) Implement code in editor
	 * 
	 * 9) Test against data set
	 * 
	 * 10) Debug if it fails    
	 */
	
	@Test
	public void example1() {
		int[] nums= {4, -1, 9, 0, 2, -4, 5};
		System.out.println(Arrays.toString(movePositive(nums)));
	}
	
	@Test
	public void example2() {
		int[] nums= {1,2,3,4,5};
		System.out.println(Arrays.toString(movePositive(nums)));
	}
	
	@Test
	public void example3() {
		int[] nums= {-1,0,-2,-9,-4};
		System.out.println(Arrays.toString(movePositive(nums)));
	}
	
	public int[] movePositive(int[] nums) {
		int pos=0,neg=0;
		
		while(neg<nums.length) {
			if(nums[neg]<0) {
				int temp=nums[pos];
				nums[pos++]=nums[neg];
				nums[neg++]=temp;
			}else
				neg++;
		}
		
		return nums;
	}
}
