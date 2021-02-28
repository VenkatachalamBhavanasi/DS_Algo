package ds.week6.classwork;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

import org.junit.Test;

public class StackVsDeque {
	
	@Test
	public void stackvs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(new ArrayList<>(stack)); // prints 1, 2, 3


		Deque<Integer> deque = new ArrayDeque<>();
		deque.push(1);
		deque.push(2);
		deque.push(3);
		System.out.println(new ArrayList<>(deque)); // prints 3, 2, 1
		
		
		System.out.println(stack.pop());
		System.out.println(deque.pop());
	}

}
