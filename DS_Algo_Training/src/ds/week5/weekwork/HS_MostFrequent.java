package ds.week5.weekwork;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Find most frequent element in array
Input: 4521542101 Output: 1 is repeated 3 times
Input: 1234234 Output: 2,3,4 are repeated 2 times 
*/
public class HS_MostFrequent {
	@Test
	public void example1() {
		int[] inp = { 4, 5, 2, 1, 5, 4, 2, 1, 0, 1 };
		System.out.println(findDuplicates(inp));
	}

	@Test
	public void example2() {
		int[] inp = { 1, 2, 3, 4, 2, 3, 4 };
		System.out.println(findDuplicates(inp));
	}

	@Test
	public void example3() {
		int[] inp = { 1, 2, 3, 4 };
		System.out.println(findDuplicates(inp));
	}

	@Test
	public void example4() {
		int[] inp = { 1 };
		System.out.println(findDuplicates(inp));
	}
	
	//Pseudo code
	/*
	 * create a hash map where each element in the array as key and its occurrence as value
	 * iterate through the input array and keep adding the element and its occurrence to the map
	 * parallely, find the max value in the value set
	 * now filter the map with key having the max value and add it to a hashset
	 * finally return the set
	 */
	//Space: O[N]
	//Time: O[N]
	
	private Set<Integer> findDuplicates1(int[] inp) {
		HashMap<Integer, Integer> map=new HashMap<>();
		
		for (int i : inp)
			map.put(i, map.getOrDefault(i, 0)+1);
		
		int max = Collections.max(map.values());
		HashSet<Integer> set=new HashSet<>();
		for (Map.Entry<Integer, Integer> mp:map.entrySet()) {
			if(mp.getValue()==max)
				set.add(mp.getKey());
		}
		
		return set;
	}
	
	private Set<Integer> findDuplicates(int[] inp) {
		HashMap<Integer, Integer> map=new HashMap<>();
		int max=Integer.MIN_VALUE;
		for (int i : inp) {
			map.put(i, map.getOrDefault(i, 0)+1);
			max=Math.max(max, map.get(i));
		}
		int maxOcc=max;
		return map.entrySet().stream().filter(m->m.getValue().equals(maxOcc)).flatMap(fm->Stream.of(fm.getKey())).collect(Collectors.toSet());
	}
}
