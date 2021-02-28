package ds.week2.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
 Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.
Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class D1HW_ReverseCharactersInArray {

	@Test
	public void example1() {
		String[] input= {"h","e","l","l","o"};
		System.out.println(Arrays.toString(reverseArray(input)));
	}
	
	@Test
	public void example2() {
		String[] input= {"h","a","n","n","a","h"};
		System.out.println(Arrays.toString(reverseArray(input)));
	}
	
	@Test
	public void example3() {
		String[] input= {"A"};
		System.out.println(Arrays.toString(reverseArray(input)));
	}
	
	/*
	 * array size is less than 2, then return the same array without any modification
	 * we need to initialize 2 pointers, one is at the start and one is at end of the array
	 * keep swapping elements from both pointers and increment left pointer and decrement right pointer 
	 * finally return the modified array
	 */
	
	//Space complexity: O[1]
	//Time complexity: O[N/2]
	private String[] reverseArray(String[] input) {
		if(input.length<2)
			return input;
		
		int left=0,right=input.length-1;
		
		while(left<right) {
			String temp=input[left];
			input[left]=input[right];
			input[right]=temp;
			left++;
			right--;
		}
		
		return input;
	}
}
