package ds.week6.homework;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
Return given string with parentheses after removing the outermost parentheses of every primitive string.

Example 1:
Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())". After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))". After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
*/

//Psuedo code
/*
 * if the stack is empty, then its outer most open bracket -> add it to the stack
 * if the stack size is greater than 0 and it is '(', then append the bracket to a output string and push it to the stack
 * if the stack size is greater than 1 and it is ')', then append to the string and pop out the open bracket
 * else, remove the last element from stack (pop)
 * 
 * Space: O[N]
 * Time: O[N]
 */
public class P4_RemoveOutermostBrackets {

	@Test
	public void example1() {
		String input = "(()())(())";
		Assert.assertEquals("()()()", removeOutBrackets(input));
	}

	@Test
	public void example2() {
		String input = "(()())(())(()(()))";
		Assert.assertEquals("()()()()(())", removeOutBrackets(input));
	}
	
	@Test
	public void example3() {
		String input = "()()()";
		Assert.assertEquals("", removeOutBrackets(input));
	}

	private String removeOutBrackets(String input) {
		Stack<Character> stack=new Stack<>();
		char[] carr = input.toCharArray();
		StringBuilder sb=new StringBuilder();
		
		for(char ch:carr) {
			if(stack.isEmpty() && ch=='(')
				stack.push(ch);
			else if(stack.size()>0 && ch=='(') {
				stack.push(ch);
				sb.append(ch);
			} else if(stack.size()>1 && ch==')') {
				stack.pop();
				sb.append(ch);
			}else 
				stack.pop();
		}
		
		return sb.toString();
	}
}
