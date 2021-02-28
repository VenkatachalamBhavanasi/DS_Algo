package ds.week8.homework;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
*/

public class ArrayIntersection {

	@Test
	public void example1() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 7, 9 };
		int[] arr3 = { 1, 3, 4, 5, 8 };
		arrayIntersection(arr1, arr2, arr3);
	}

	@Test
	public void example2() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 5, 7, 9 };
		int[] arr3 = { 1, 2, 3, 5, 8 };
		arrayIntersection(arr1, arr2, arr3);
	}

	private void arrayIntersection(int[] arr1, int[] arr2, int[] arr3) {

		int p1 = 0, p2 = 0, p3 = 0;
		List<Integer> list = new ArrayList<>();
		while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
			if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
				list.add(arr1[p1++]);
				p2++;
				p3++;
			}

			else if (arr1[p1] < arr2[p2])
				p1++;
			else if (arr2[p2] < arr3[p3])
				p2++;
			else
				p3++;
		}

		System.out.println(list);
	}
}
