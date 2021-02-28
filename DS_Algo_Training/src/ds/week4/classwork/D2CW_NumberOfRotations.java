package ds.week4.classwork;

import org.junit.Test;

//Given an integer array, find how many times it is rotated

public class D2CW_NumberOfRotations {
	
	// 5, 6, 7, 8 -> number of items: 4 
	// Is it sorted -> yes
	// 8, 5, 6, 7
	// 7, 8, 5, 6
	
	
	@Test
	public void example1() {
		int[] numbers = {1,2,3,4};
		int count = getRotationCount(numbers);
		System.out.println(count); // 0 rotations
	}
	
	@Test
	public void example2() {
		int[] numbers = {4,-2,-1,3};
		int count = getRotationCount(numbers);
		System.out.println(count); // 1 rotations
	}
	
	@Test
	public void example3() {
		int[] numbers = {5,6,7,3,4};
		int count = getRotationCount(numbers);
		System.out.println(count); // 3 rotations
	}

	private int getRotationCount(int[] numbers) {
		
		return recursion(numbers,0, numbers.length-1);
	}

	// optimized by the mid position
	private int recursion(int[] numbers, int left, int right) {
		
		if(right == left)
			return left;
		
		int mid = (left + right) / 2;
		
		if(mid < right && numbers[mid+1] < numbers[mid])
			return mid+1;
		
		if(mid > left && numbers[mid] < numbers[mid-1])
			return mid;
		
		if(numbers[right] > numbers[left])
			return recursion(numbers, left, mid-1);
		else
			return recursion(numbers, mid+1, right);
	}
	
	/*
	 * Rules to break the recursion
	 * 1) when the array is not rotated? right > left 
	 * 2) If the array is left with one element 
	 * left > right => length - (right-left) 
	 * 
	 * Psuedocode
	 * 1) mid
	 * 2) left -> mid
	 * 3) mid+1 -> right
	 * 
	 */
	

}
