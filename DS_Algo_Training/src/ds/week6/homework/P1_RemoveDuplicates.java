package ds.week6.homework;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s of lower and upper case English letters. Remove characters from string if s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa. Return the string after operation. 

Example:
Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
*/

public class P1_RemoveDuplicates {

	@Test
	public void example1() {
		String s = "AbBaCC";
		Assert.assertEquals("CC", removeDuplicates(s));
	}

	@Test
	public void example2() {
		String s = "leeEtscode";
		Assert.assertEquals("letscode", removeDuplicates(s));
	}

	@Test
	public void example3() {
		String s = "a";
		Assert.assertEquals("a", removeDuplicates(s));
	}

	private String removeDuplicates(String s) {
		if (s.length() < 2)
			return s;

		Stack<Character> stack = new Stack<>();
		char[] charr = s.toCharArray();

		for (char ch : charr) {
			if (!stack.isEmpty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(ch)
					&& stack.peek() != ch)
				stack.pop();
			else
				stack.push(ch);
		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty())
			sb.append(stack.pop());

		return sb.reverse().toString();
	}
}
