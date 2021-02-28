package ds.week3.classwork;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then words can be in any order.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words
*/

public class D1HW_KFrequentElements {

	@Test
	public void example1() {
		String[] input= {"i", "love", "leetcode", "i", "love", "coding"};
		int k=2;
		findKFrequentWords(input,k);
	}
	
	@Test
	public void example2() {
		String[] input= {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k=4;
		findKFrequentWords(input,k);
	}
	
	
	/* Create a map to store each element as key and its occurrence as value
	 * Sort the map by its value in descending order i.e. words with most number of occurrences comes first
	 * Take only first k elements from the sorted map and store it in an output list
	 * Finally return the output list*/	
	//Space complexity: O[N log N]
	//Time complexity: O[N]
	
	private void findKFrequentWords(String[] input, int k) {
		Map<String, Integer> frequencies=new HashMap<>();	//Creating a hash map to store elements and its frequencies
		
		for (String eachEl:input)
			frequencies.put(eachEl, frequencies.getOrDefault(eachEl,0 )+1);	//add each element to map and update its occurrence count accordingly
		//JAVA 8 implementation to sort map
		
		//Entry set is combo of key and value
		//Stream method is used to process the sequence of elements (here it process the entry set of map)
		List<String> freqEle = frequencies.entrySet().stream()	
		//By comparing the value, sort the entries in map in reverse order		
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		//consider only first k elements in the sorted map
		.limit(k)
		//flat map converts 2D elements to 1D elements
		//Here we are converting 2D entries to 1D entry keys
		.flatMap(fm->Stream.of(fm.getKey()))
		//Finally collecting the keys as list "freqEle"
		.collect(Collectors.toList());
		
		//Return or print the list of first k frequent element in descending order
		System.out.println(freqEle);
	}
}
