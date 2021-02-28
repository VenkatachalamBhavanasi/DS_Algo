package ds.week4.classwork;

import org.junit.Test;

//Given an sorted integer array with 1's and 0's, find number of 1's in the array
public class D2CW_CountOnes {
	
	@Test
	public void example1() {
		int[] numbers = {0,0,0,0,0,1,1,1};
		int count = getOneCount(numbers);
		System.out.println(count);
	}

	private int getOneCount(int[] numbers) {
		return recursion(numbers,0,numbers.length-1);
	}

	private int recursion(int[] numbers, int left, int right) {
		
		if(numbers[right] == 0)
			return 0;
		
		if(numbers[left] == 1)
			return right - left + 1;
		
		int mid = (left + right)/2;
		return recursion(numbers,left,mid) + recursion(numbers,mid+1,right);
				
	}

}
