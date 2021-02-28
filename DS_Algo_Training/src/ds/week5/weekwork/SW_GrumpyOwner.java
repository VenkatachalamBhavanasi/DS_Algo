package ds.week5.weekwork;

import java.util.Iterator;

import org.junit.Assert;

/*
Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16

Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
*/

public class SW_GrumpyOwner {

	public void example1() {
		int[] customers= {1,0,1,2,1,1,7,5};
		int[] grumpy= {0,1,0,1,0,1,0,1};
		int X=3;
		Assert.assertEquals(16, maxSatisfied(customers, grumpy, X));
	}
	
	public void example2() {
		int[] customers= {1,2,3,4,5};
		int[] grumpy= {1,1,1,1,1};
		int X=2;
		Assert.assertEquals(9, maxSatisfied(customers, grumpy, X));
	}
	
	public void example3() {
		int[] customers= {1,2,3,4,5};
		int[] grumpy= {0,0,0,0,0};
		int X=2;
		Assert.assertEquals(15, maxSatisfied(customers, grumpy, X));
	}
	
	//Pseudo code
	/*
	 *iterate through each element in grumpy array
	 	* if the value is 0, then add customer[current index] to the sum 
	 * create a new variable maxSum and intialize it as sum
	 * again slide through the grumpy array 
	 	* if the current value is 1, add its corresponding value of customer to sum
	 	* if the window size greater than x, remove the first element and add the last element
	 * for each iteration, calculate the maxsum
	 */
	//Space: O[1]
	//Time: O[N]
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int sum=0;
		for (int i = 0; i < grumpy.length; i++) {
			if(grumpy[i]==0)
				sum+=customers[i];
		}
		int maxSum=sum;
		int start=0;
		
		for (int end = 0; end < grumpy.length; end++) {
			if(grumpy[end]==1)
				sum+=customers[end];
			
			if(end>=X && grumpy[start]==1)
				sum-=customers[start++];
			
			maxSum=Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
