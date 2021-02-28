package ds.week3.classwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/
public class D1CW_UniqueOccur {
	private boolean isUnique(int[] data) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < data.length; i++) 
			map.put(data[i], map.getOrDefault(data[i], 0)+1);
		return map.size() == new HashSet<>(map.values()).size();
	}

	@Test
	public void example1() {
		int[] data = {1,2,2,1,1,3};
		// 1 -> 3
		// 2 -> 2
		// 3 -> 1
		boolean unique = isUnique(data);
		System.out.println(unique);
	}
	
	@Test
	public void example2() {
		//  1 -> 1
		//  2 -> 1
		int[] data = {1,2};
		boolean unique = isUnique(data);
		System.out.println(unique);
	}

	@Test
	public void example3() {
		int[] data = {-3,0,1,-3,1,1,1,-3,10,0};
		boolean unique = isUnique(data);
		System.out.println(unique);
	}
}
