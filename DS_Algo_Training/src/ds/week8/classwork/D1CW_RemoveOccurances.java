package ds.week8.classwork;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given the int array and a target k, remove all the occurrence of target from the array and find the new length of the array
 * numbers = [0,1,2,2,3,0,4,2], number = 2
 * Output: 5
 */
public class D1CW_RemoveOccurances {
	/*
	 * Iterate through each number in the array
	 * Compare if that number is the same as k
	 * if yes, reduce the return size by one
	 * finally, return the count
	 * 
	 */
	// Time complexity -> o(n/2) 
	// Space -> o(1)
	private int removeNumber(int[] n, int k) {
		int count = n.length, left=0, right=n.length-1;
		while(left <= right) {
			if(left==right && n[right] == k) {
				count--;
				break;
			}
			if(n[left++] == k)
				count--;
			if(n[right--] == k)
				count--;
			
		}
		return count;
	}
	
	private int removeNumberUsingLinear(int[] n, int k) {
		int count = n.length;
		for (int i = 0; i < n.length; i++) {
			if(n[i] == k)
				count--;
		}
		return count;
	}

	@Test
	public void test1() {
		int[] n = {2,4,8,12,4,8,4,1,2};
		int k = 2;
		int result = removeNumber(n,k);
		Assert.assertEquals(result, 7);
	}
	
		@Test
	public void test2() {
		int[] n = {-2,-2,-2,-2};
		int k = -2;
		int result = removeNumber(n,k);
		Assert.assertEquals(result, 0);
	}

	@Test
	public void test3() {
		int[] n = {2,4,6,8};
		int k = 0;
		int result = removeNumber(n,k);
		Assert.assertEquals(result, 4);
	}
	@Test
	public void test4() {
		int[] n = {1,2,1};
		int k = 2;
		int result = removeNumber(n,k);
		Assert.assertEquals(result, 2);
	}
}
