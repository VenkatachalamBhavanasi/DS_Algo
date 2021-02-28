package ds.week8.classwork;

import java.util.Arrays;

import org.junit.Test;

/*
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output â€œFizzâ€� instead of the number and for the multiples of five output â€œBuzzâ€�. For numbers which are multiples of both three and five output â€œFizzBuzzâ€�.
n = 15,
Return: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
*/

public class D1CW_FizzBuzz {
	
	@Test
	public void test1() {
		int n = 15;
		String[] result = fizzBuzzUsing2Pointers(n);
		System.out.println(Arrays.toString(result));
	}
	
	@Test
	public void test2() {
		int n = 30;
		String[] result = fizzBuzzUsing2Pointers(n);
		System.out.println(Arrays.toString(result));
	}

	@Test
	public void test3() {
		int n = 1;
		String[] result = fizzBuzzUsing2Pointers(n);
		System.out.println(Arrays.toString(result));
	}
	
	/*
	 * Iterative Approach
	 * Traverse through each number in the n index
	 * Validate if the number is divisible by
	 * 3 -> Fizz
	 * 5 -> Buzz
	 * 15 -> FizzBuzz
	 * else -> String of that number
	 */
	
	// Performance of this solution
	// Time complexity : O(n) [Can i reduce my time or space complexity]
	// Space complexity: O(n) [No possibility reducing the space]
	private String[] fizzBuzz(int n) {
		String[] output = new String[n];
		for (int i = 1; i <= n; i++) {
			if(i%15 == 0)
				output[i-1] = "FizzBuzz";
			else if(i%3 == 0)
				output[i-1] = "Fizz";
			else if(i%5 == 0)
				output[i-1] = "Buzz";
			else
				output[i-1] = ""+i+"";
		}
		return output;
	}
	
	// 2 Pointers (left and right)
	// 2 types -> Equi & Opposite 
	
	/*
	 * Move your one pointer from left to right and do the same logic
	 * whereas move your other pointer from right to left and do the same logic
	 * when both meets, stop !!
	 */
	
	private String[] fizzBuzzUsing2Pointers(int n) {
		String[] output = new String[n];
		int left=1, right=n;
		while(left <= right) {
			if(left%15 == 0)
				output[left-1] = "FizzBuzz";
			else if(left%3 == 0)
				output[left-1] = "Fizz";
			else if(left%5 == 0)
				output[left-1] = "Buzz";
			else
				output[left-1] = ""+left+"";
			
			if(right%15 == 0)
				output[right-1] = "FizzBuzz";
			else if(right%3 == 0)
				output[right-1] = "Fizz";
			else if(right%5 == 0)
				output[right-1] = "Buzz";
			else
				output[right-1] = ""+right+"";
			left++;
			right--;
		}
		return output;
	}
	
	
	
	
	
	
}
