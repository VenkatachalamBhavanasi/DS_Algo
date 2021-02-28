package ds.week3.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class LearnHash {
	
	@Test
	public void getHash() {
		
		//String s1 = "FB"; 
		//String s1 = "Ea";
		
		String s1 = null; //Sam, Rajesh
		System.out.println(s1.hashCode());
		System.out.println(s1.hashCode() & 15);

		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Babu", 42);
		map.put("Ajay", 26);
		map.put("Hari", 40);
		map.put("Sam",  30);
		map.put("Rajesh", 29);
		map.remove("Babu");
		//map.put
		
		System.out.println(map.get("Ajay")); // hashcode -> index -> value
		
//		map.get(s1);
		
		
		
		// Map -> Key : Value
		// Key -> Unique or not? Unique
		// Value -> Not necessary !!
		// Every Key should have a value !! -> Key+Value -> Entry
		// Implementation: Fastest solution for HashMap ??
		
			// Add entry -> put
			// Verify the key exist -> containsKey
			// Delete an entry -> remove
			// Size of the map -> size
		
		
		// For every given key -> Find the Hash Value !! (32 bit) -> Number
		// Fit into the specific index based on the number	
		
	}

}
