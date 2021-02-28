package ds.week8.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
Given an integer array perform right rotation a given number of times, N
and print the output. N < length of array.

Input: [4,6,3,8,2,9,1,36]
N = 4
Output: [2,9,1,36,4,6,3,8]
*/

public class D1CW_RotateArray {

	@Test
	public void test1() {
		int[] num = {4,6,3,8,2,9,1,36};
		int[] rotate = rotate(num, 4);
		System.out.println(Arrays.toString(rotate));
	}

	private int[] rotate(int[] num, int k) {
		int left = k-1, right = num.length-1;
		for(int i=1; i<=k; i++) {
			int temp = num[right];
			num[right--] = num[left];
			num[left--] = temp;
		}
	   return num;
	}

}
