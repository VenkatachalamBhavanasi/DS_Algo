package ds.week6.classwork;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

Example 1:
Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Note: S consists only of English lowercase letters.
*/

//Pseudo Code
/*
 * If the string length is less than 2, return the input string directly
 * Convert the string to character array
 * add the characters to the stack
 * check the top element in the stack is equal to the current element
 	* then, remove the top element (pop) and skip the current element
 	* else, add the current element to the stack
 * once the iteration is completed, pop out all the elements from the stack and concatenate to a single string 
 * return the string
 * 
 * Space: O[N]
 * Time: O[N]
 */

public class D1HW_RemoveDuplicates {

	@Test
	public void example1() {
		String input = "abbaca";
		Assert.assertEquals("ca", removeDuplicates(input));
	}

	@Test
	public void example2() {
		String input = "abcd";
		Assert.assertEquals("abcd", removeDuplicates(input));
	}

	@Test
	public void example3() {
		String input = "abbbcd";
		Assert.assertEquals("abcd", removeDuplicates(input));
	}

	@Test
	public void example4() {
		String input = "aabb";
		Assert.assertEquals("", removeDuplicates(input));
	}

	@Test
	public void example5() {
		String input = "a";
		Assert.assertEquals("a", removeDuplicates(input));
	}

	private String removeDuplicates(String input) {
		if(input.length()<2)
			return input;
		
		char[] chararray=input.toCharArray();
		
		Stack<Character> stack=new Stack<>();
		
		for (char ch : chararray) {
			if(!stack.isEmpty() && stack.peek()==ch)
				stack.pop();
			else
				stack.push(ch);
		}
		
		StringBuilder sb=new StringBuilder();
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		return sb.reverse().toString();
	}
}
