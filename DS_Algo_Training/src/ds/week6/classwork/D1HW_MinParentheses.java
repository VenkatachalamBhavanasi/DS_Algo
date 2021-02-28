package ds.week6.classwork;
/*
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
Formally, a parentheses string is valid if and only if:
It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

SAMPLE INPUT 
()))((
SAMPLE OUTPUT 
4
Explanation
The given string can be balanced to "((()))(())", requiring 4 more paranthesis minimum.
*/
//Pseudo code
/*
 * convert the input string to a character array
 * add each character to the stack
 	* if the top element is '(' and the current element is ')' then remove the top element from the stack 
 	* and skip the current element
 * at the end of iteration stack will have only non pair (not closed) brackets
 * finally return the size of the stack
 * 
 * Space: O[N]
 * Time: O[N]
 */
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class D1HW_MinParentheses {

	@Test
	public void example1() {
		String input = "()))((";
		Assert.assertEquals(4, findMinBracketsRequired(input));
	}

	@Test
	public void example2() {
		String input = "(())";
		Assert.assertEquals(0, findMinBracketsRequired(input));
	}

	@Test
	public void example3() {
		String input = "(()()";
		Assert.assertEquals(1, findMinBracketsRequired(input));
	}

	@Test
	public void example4() {
		String input = "(";
		Assert.assertEquals(1, findMinBracketsRequired(input));
	}
	
	@Test
	public void example5() {
		String input = "))()((";
		Assert.assertEquals(4, findMinBracketsRequired(input));
	}

	private int findMinBracketsRequired(String input) {
		
		char[] charArray = input.toCharArray();
		Stack<Character> stack=new Stack<>();
		
		for(char ch: charArray) {
			if(!stack.isEmpty() && stack.peek()=='(' && ch==')')
				stack.pop();
			else
				stack.push(ch);
		}
		
		return stack.size();
	}
}
