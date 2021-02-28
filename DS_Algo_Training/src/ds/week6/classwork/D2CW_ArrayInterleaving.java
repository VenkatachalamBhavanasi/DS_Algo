package ds.week6.classwork;

import java.util.ArrayDeque;
import java.util.Stack;

import org.junit.Test;

/*
Given a queue of integers of even length, rearrange the elements by interleaving the first half of the queue with the second half of the queue.
Only a stack can be used as an auxiliary space.

Examples:
Input :  1 2 3 4
Output : 1 3 2 4

Input : 11 12 13 14 15 16 17 18 19 20
Output : 11 16 12 17 13 18 14 19 15 20
*/

public class D2CW_ArrayInterleaving {

	@Test
	public void example1() {
		int[] input = { 1, 2, 3, 4 };
		arrayInterleaving(input);
	}

	@Test
	public void example2() {
		int[] input = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		arrayInterleaving(input);
	}

	private void arrayInterleaving(int[] input) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		for (int i : input)
			queue.offer(i);

		int len = input.length/2;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < len; i++)
			stack.push(queue.poll());

		while (!stack.empty())
			queue.add(stack.pop());

		for (int i = 0; i < len; i++)
			queue.add(queue.poll());

		for (int i = 0; i < len; i++)
			stack.push(queue.poll());

		while (!stack.empty()) {
			queue.add(stack.pop());
			queue.add(queue.poll());
		}

		System.out.println(queue);
	}
}
