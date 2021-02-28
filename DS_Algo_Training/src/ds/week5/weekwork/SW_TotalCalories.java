package ds.week5.weekwork;

import org.junit.Test;

/*
A dieter consumes calories[i] calories on the i-th day. For every consecutive sequence of k days, they look at T, the total calories consumed during that sequence of k days:

If T < lower, they performed poorly on their diet and lose 1 point;
If T > upper, they performed well on their diet and gain 1 point;
Otherwise, they performed normally and there is no change in points.
Return the total number of points the dieter has after all calories.length days.

Note that: The total points could be negative.

Example 1:
Input: calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
Output: 0
Explaination: calories[0], calories[1] < lower and calories[3], calories[4] > upper, total points = 0.

Example 2:
Input: calories = [3,2], k = 2, lower = 0, upper = 1
Output: 1
Explaination: calories[0] + calories[1] > upper, total points = 1.

Example 3:
Input: calories = [6,5,0,0], k = 2, lower = 1, upper = 5
Output: 0
Explaination: calories[0] + calories[1] > upper, calories[2] + calories[3] < lower, total points = 0.
*/

public class SW_TotalCalories {
	@Test
	public void example1() {
		int[] input = { 1, 2, 3, 4, 5 }; // 0
		int k = 1, low = 3, up = 3;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example2() {
		int[] input = { 3, 2 }; // 1
		int k = 2, low = 0, up = 1;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example3() {
		int[] input = { 6, 5, 0, 0 }; // 0
		int k = 2, low = 1, up = 5;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example4() {
		int[] input = { 6, 5 };
		int k = 3, low = 1, up = 5;
		checkCalories(input, k, low, up);
	}

	@Test
	public void example5() {
		int[] input = { 6, 5, 6, 5, 6 };
		int k = 2, low = 11, up = 11;
		checkCalories(input, k, low, up);
	}

	private void checkCalories(int[] input, int k, int low, int up) {

		int sum = 0, cal = 0;

		if (input.length < k)
			throw new RuntimeException("Invalid input");

		for (int i = 0; i < k; i++)
			sum += input[i];

		for (int i = k; i <= input.length; i++) {
			if (sum < low)
				cal--;
			else if (sum > up)
				cal++;

			sum += i < input.length ? input[i] - input[i - k] : 0;
		}

		System.out.println(cal);
	}
}
