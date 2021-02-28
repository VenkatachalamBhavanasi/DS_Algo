package ds.week1.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
4) Given two arrays,find the intersection of 2 arrays.

Input: nums1 = [11,2,12,1], nums2 = [2,12]
Output: [2,12]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
*/
public class D1HW_ArrayIntersection {
	@Test
	public void example1() {
		int[] nums1 = { 11, 2, 12, 1 };
		int[] nums2 = { 2, 12 };
		System.out.println(arrayIntersection(nums1, nums2));
	}

	@Test
	public void example2() {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		System.out.println(arrayIntersection(nums1, nums2));
	}

	private List<Integer> arrayIntersection(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums2[j] == nums1[i]) {
					list.add(nums1[i]);
					break;
				}
			}
		}
		return list;
	}
}
