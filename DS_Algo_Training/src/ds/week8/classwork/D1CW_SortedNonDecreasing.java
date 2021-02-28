package ds.week8.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array of integers sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
Input: [-8,-3,4,3,10]
Output: [9,9,16,64,100]
*/

public class D1CW_SortedNonDecreasing {
	
	@Test
	public void test1() {
		int[] n = {-8,-7,-6};
		int[] result = squareNumbersUsingSwap(n);
		System.out.println(Arrays.toString(result));
	}

	// Time Complexity: O(n)
	// Space Complexity = O(n)
	private int[] squaredSort(int[] n) {
		int length = n.length, left =0, right = length-1;
		int[] output = new int[length];
		for (int i = length-1; i >=0 ; i--) {
			if(Math.abs(n[right]) > Math.abs(n[left]))
				output[i] = n[right]*n[right--];
			else
				output[i] = n[left]*n[left++];
		}
		return output;
	}
	
	private int[] squareNumbersUsingSwap(int[] numbers) {
    	if(numbers.length < 1)
    		return numbers;
    	
    	int left = 0, right = numbers.length-1;
    	while(left <= right){
    		if(Math.abs(numbers[left]) > Math.abs(numbers[right])){
    			int swap = numbers[right];
    			numbers[right] = numbers[left] * numbers[left];
    			numbers[left] = swap;
    			right--;
    		}else{
    			numbers[right] = numbers[right] * numbers[right];
    			right--;
    		}
    	}
    	return numbers;
    }
	
	
	
	
	
	
}
