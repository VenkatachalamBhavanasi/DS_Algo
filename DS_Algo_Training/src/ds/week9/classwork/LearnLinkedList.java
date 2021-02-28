package ds.week9.classwork;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LearnLinkedList {
	
	// Add, Remove => Performance => LinkedList !!
	@Test
	public void linkList() {
		
		LinkedList<String> lst = new LinkedList<>();
		lst.add("Babu");
		lst.add("Hari");
		lst.add("Ajay");
		String name = lst.listIterator(2).next();
		System.out.println(name);
	}

	 // Create a LinkedList
	 // 1 <-> 2 <-> 3 <-> 4 <-> 5
	// Reverse the LinkedList (Iterative -> Linear)
	
}
