package ds.week8.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Given an integer array return all the subarray (start and end index) with sum matching target
Note: Sliding window+Hashing
Input: int[] num={1, 7, 4, 3, 4, 1, 2, 5, 1};
int target=7
Output:
1,1
2,3
3,4
4,6
6,7
*/

public class D2CW_ExactSum {


	@Test
	public void example2() {

		int[] numbers = {1,7,4,3,4,1,2,5,1};
		int target = 7;
		
		solveUsingHash(numbers, target);
		//System.out.println(Arrays.toString(exactSum));
	}
	
	// O(n)
	// O(1)
	private int[] exactSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) { // outer loop
			int current = numbers[i];
			if(current == target) 
				System.out.println(i + " - " + i);
			if(current > target)  continue;
			for (int j = i+1; j < numbers.length; j++) {
				current += numbers[j];
				if(current < target)  continue;
				if(current > target)  break;
				if(current == target) 
					System.out.println(i + " - " + j);
			}
		}
		return new int[] {-1, -1};
	}
	
	private void solveUsingHash(int[] numbers, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		// Initialize the first value with negative number
		map.put(0, -1);

		// What is the sum so far?
		int sum_so_far = 0;

		for (int i = 0; i < numbers.length; i++) { // O[N]
			sum_so_far += numbers[i];			
			int diff = sum_so_far - target;			
			if(map.containsKey(diff)) {
				System.out.println("Found the sub array : {"+(map.get(diff)+1)+" , "+ i +"}");
			}
			map.put(sum_so_far, i);
		}

		System.out.println("^^^^^^^^^^^^^^");
		//throw new RuntimeException("There is no matching indices");
	}
}
