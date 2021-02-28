package ds.week3.classwork;

import org.junit.Test;
//Find if k is present in the given integer array
public class D2CW_FindNumber {

	@Test
	public void example1() {
		int[] data = {1, 4, 6, 7, 9, 14, 17, 18, 19, 25, 27, 29,34, 37};
		int k = 9;
		System.out.println(binarySearch(data, k));
	}
	
	/*
	 * Friend -> Street !!
	 * 
	 */
	
	// Time Complexity: n
	
	// Solving more Java problems - String, Arrays
	// Focus on optimization and not coding itself
	// Multiple alternate solutions
		
	private boolean linearSearch(int[] data, int k) {
		for (int i = 0; i < data.length; i++) {
			System.out.println(i);
			if(data[i] == k)
				return true;
		}
		return false;
	}
	
	// 2 pointer algorithm
	// Time Complexity: O[n/2]
	private boolean twoPointer(int[] data, int k) {
		int left = 0;
		int right = data.length-1;
		while(left < right) {
			System.out.println("I am");
			if(data[left] == k || data[right] == k) {
				return true;
			}
			left++;
			right--;
		}
		return false;
	}
	
	// o(log n)
	private boolean binarySearch(int[] data, int k) {
		int low = 0, high = data.length-1;
		while(low <= high) {
			int mid =  (low + high) / 2;
			if(data[mid] == k)
				return true;
			else if(data[mid] < k) {
				low = mid+1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
