package ds.week6.classwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class D1CW_ValidParanthesis {

	@Test
	public void example1() {
		String str = "()[]";
		boolean bValid = isValidParanthesis(str);
		System.out.println(bValid);
	}
	
	/*
	 * Convert the String to character Array
	 * Create a stack and map 
	 * Map -> Add with key as closed brackets and value as equ open brackets
	 * Start traversing with each character through loop
	 * 	a) Check if the given character is closed bracket (check map)	
	 * 		i) If yes, look at the last element of the stack and check if the map value matches
	 * 				a) If the value does not matches -> return false !!
	 * 				b) If it matches, remove it (pop)
	 * 		ii) If not, add to the stack
	 * 	b) Finally, check if the given stack is empty -> return true else false !!
	 */
	
	// Stack -> Single Dimensional
		// LIFO
		// push, peek, pop, isEmpty
		// Valid Paranthesis, Undo, Compile, 
	
	
	private boolean isValidParanthesis(String str) {
		
		// Convert the String to character Array
		char[] ch = str.toCharArray();
		
		// We check if the given String is odd that means it is not valid
		if(ch.length %2 == 1)
			return false;
		
		// Create a stack and map 
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		
		// Map -> Add with key as closed brackets and value as equ open brackets
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('>', '<');
		
		// Start traversing with each character through loop
		for (Character c : ch) {
			// Check if the given character is closed bracket (check map)
			if(map.containsKey(c)) {
				// If yes, look at the last element of the stack and check if the map value matches
				if(stack.isEmpty() || stack.pop() != map.get(c)) {
					return false;
				}
			} else { // if not add to the stack
				stack.push(c);
			}
		}
		// Finally, check if the given stack is empty -> return true else false !!
		return stack.isEmpty();
	}

	@Test
	public void example2() {
		String str = "([])";
		boolean bValid = isValidParanthesis(str);

		System.out.println(bValid);

	}
	
	@Test
	public void example3() {
		String str = ")(";
		boolean bValid = isValidParanthesis(str);

		System.out.println(bValid);

	}
	
	@Test
	public void example4() {
		String str = "()(";
		boolean bValid = isValidParanthesis(str);

		System.out.println(bValid);

	}

	private boolean validate(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
