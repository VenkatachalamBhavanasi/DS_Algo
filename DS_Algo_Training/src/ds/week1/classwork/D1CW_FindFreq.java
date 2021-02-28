package ds.week1.classwork;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class D1CW_FindFreq {
	
/*
Find the frequency of a number in an array
Given an array a[] and an element x, find number of occurrences of x in a[].

Examples:
Input  : a[] = {0, 5, 5, 5, 4}	x = 5
Output : 3

Input  : a[] = {1, 2, 3}	x = 4
Output : 0
*/
	@Test
	public void example1() {
		int[] arr = { 0, 5, 5, 5, 4 };
		int x = 5;
		Assert.assertEquals(3, findXFreq(arr, x));
	}
	
	@Test
	public void example2() {
		int[] arr = { 1, 2, 3 };
		int x = 4;
		Assert.assertEquals(0, findXFreq(arr, x));
	}
	
	private int findXFreq(int[] arr, int x) {
		Arrays.sort(arr);
		int cnt=0;
		for (int i : arr) {
			if(i==x)
				cnt++;
		}
		
		return cnt;
	}

}
