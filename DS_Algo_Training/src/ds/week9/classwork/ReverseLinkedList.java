package ds.week9.classwork;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ReverseLinkedList {
	
	// Add, Remove => Performance => LinkedList !!
	@Test
	public void linkList() {
		
		LinkedList<Integer> lst = new LinkedList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		lst.add(5);
		
		// Create a new LinkedList (O(n)) and then traverse from right to left and keep adding
		// Time Complexity : O(n)
		/*LinkedList<Integer> reverse = new LinkedList<>();
		for (int i = lst.size()-1; i >=0; i--) {
			reverse.add(lst.get(i));
		} */
		// Use Swap using left and right pointer on same LL
		int left=0, right=lst.size()-1,temp=0;
		while(left < right) {
			temp = lst.listIterator(right).next();
			lst.set(right, lst.listIterator(left).next());
			lst.set(left, temp);
			right--;
			left++;
		}
		// Time Complexity: O(n/2)
		// Space Complexity: O(1)
		
		System.out.println(lst);
	}

	 // Create a LinkedList
	 // 1 <-> 2 <-> 3 <-> 4 <-> 5
	// Reverse the LinkedList (Iterative -> Linear)
	
}
