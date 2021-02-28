package ds.week6.classwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class D2CW_DecodeString {

	@Test
	public void example1() {
		String s="3[a2[bc]]";	//abcbcabcbcabcbc
		decodeString(s);
	}
	
	//O(n*m) -> Number of characters n * number of open brackets (m)
	//O(2n)
	/*
	 * Pseudocode
	 * 	1) Create a stack
	 * 	2) Traverse through each character of the string
	 * 	3) If the character is NOT closing bracket -> add to the stack
	 * 	   Else, go to next step
	 * 	4) Create a List to store the popped character
	 * 	5) Until the character is open bracket -> keep popping and store to list
	 *  6) Pop the open bracket
	 *  7) If the character before the open bracket is number -> store the k value as number
	 *  8) Decode k by pushing the decode string so far k times to stack
	 *  9) Finally print the stack or return after converting as string
	 */
	private void decodeString(String s) {
		// Create a stack
		Stack<Character> stack = new Stack<>();

		// Traverse through each character of string
		for (int i = 0; i < s.length(); i++) {
			// If the character is NOT closing bracket
			if (s.charAt(i) != ']')
				stack.push(s.charAt(i)); // add to the stack
			else {
				List<Character> lst = new ArrayList<>(); // Create a List to store the popped character

				// Until the character is open bracket
				while (stack.peek() != '[')
					lst.add(stack.pop()); // keep popping and store to list

				// Pop the open bracket
				stack.pop();

				int k = 1;
				if (!stack.isEmpty() && Character.isDigit(stack.peek()))
					k = Character.getNumericValue(stack.pop());

				// Decode the string based on k
				while (k > 0) {
					for (int j = lst.size() - 1; j >= 0; j--)
						stack.push(lst.get(j)); // Push back to stack

					k--;
				}
				System.out.println();
			}
		}
	}
}

// Solve 1 Medium sized Stack
// Understand Queue -> Learn 1 + Solve 1 
// Learning Hashing Algorithm !!