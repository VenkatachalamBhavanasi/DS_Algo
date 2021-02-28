package ds.week6.classwork;

import java.util.ArrayDeque;
import java.util.Stack;

import org.junit.Test;

public class D2CW_ReverseElements {
	
	@Test
	public void test1() {
		int[] data = {10,12,14,16,18,20};
		int k = 3;
		reverseKElements(data, k);
		// 14,12,10,16,18,20
	}
	
	@Test
	public void test2() {
		int[] data = {10,10,10,16,18,20};
		int k = 3;
		reverseKElements(data, k);
		// 10,10,10,16,18,20
	}
	
	@Test
	public void test3() {
		int[] data = {10,10,10,16,18,20};
		int k = 8;
		reverseKElements(data, k);
	}
	
	// ArrayDeque -> Queue Implementation
	
	/*
	 * Iterate every item from the given array
	 * 	a) For the first k items, use stack
	 *  b) For the remaining item, use queue
	 *  stack -> 10, 20, 30 (push)
	 *  queue -> 40, 50, 60 (offer)
	 * 
	 * Get the item from stack (pop) and add them to the queue
	 * queue -> 40, 50, 60, 30, 20, 10
	 * 			50, 60, 30, 20, 10, 40
	 * 			60, 30, 20, 10, 40, 50
	 * Dequeue (poll) only the total - k items from the queue
	 * And enque (offer) in the same queue
	 * final -> 30, 20, 10, 40, 50, 60
	 * 
	 */
	
	private void reverseKElements(int[] data, int k) {
		//For the first k items, 
			// a) use stack
			// b) For the remaining item, use queue
		
		if(k > data.length)
			throw new RuntimeException("Invalid Input");
		
		Stack<Integer> stack = new Stack<Integer>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		
		for (int i = 0; i < data.length; i++) {
			if(i < k)
				stack.push(data[i]);
			else
				queue.offer(data[i]);
		}
		
		// Get the item from stack (pop) and add them to the queue
		for (int i = 0; i < k; i++) {
			queue.offer(stack.pop());
		}
		
		//  Dequeue (poll) only the total - k items from the queue
		for (int i = 0; i < data.length-k; i++) {
			queue.offer(queue.poll());
		}
		System.out.println(queue);
	}
}
