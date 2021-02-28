package ds.week3.classwork;
/*
Given 2 strings, find all the start indices of second string anagrams in first string.
Note:
Strings consists of lowercase letters only 
The order of output does not matter.
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Input:
s: "testetr" p: "te"
Output:
[0, 3, 4]
Sliding Window + HashMap 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class D2CW_ReturnIndicies {
	@Test
	public void test1() {
		
		String s = "acbbccbabbcaac";
		String p = "abc";
		findAnagrams(s, p);
		
	}
	
	@Test
	public void test2() {
		
		String s = "acb";
		String p = "bbc";
		findAnagrams(s, p);
		
	}
	
	@Test
	public void test3() {
		
		String s = "acb";
		String p = "bbcd";
		findAnagrams(s, p);
		
	}
	
	/*  
	 *  Approach: Sliding Window + Hashing Algo
	 *  - Consecutive Elements
	 *  - K size (Size of the anagram String)
	 *  - Need to compare the number of characters and its occurrences (anagram) 
	 * 
	 *  PsuedoCode:
	 *  
	 *  1) Create 2 Maps for each String (s, p)
	 *  2) Iterate through anagram string (p) and fill the map
	 *  3) Iterate the string (s) from left -> right
	 *  	a) Get the character of the iteration
	 * 		b) Put that in the map
	 * 		c) Check if the i count > anagram string and if yes
	 * 				i) remove the last character from map (either decrement the count or remove)
	 * 				ii) if there is only one occurrence, remove else decrement the count - 1 
	 * 		d) Compare both map and if matches -> add the index to List
	 *   4) Return the list of indices 
	 *   
	 *   Edge Condition: If the p length > s length : throw exception
	 */
	
	private void findAnagrams(String s, String p){
		
		int sLen = s.length();
		int pLen = p.length();
		
		if(pLen > sLen)
			throw new RuntimeException("The angram is bigger than the String length");
		
		HashMap<Character, Integer> pCount = new HashMap<>();
		HashMap<Character, Integer> sCount = new HashMap<>();

		for (int i = 0; i < pLen; i++) {
			pCount.put(p.charAt(i), pCount.getOrDefault(p.charAt(i), 0)+1);
		}
		
		
		for (int i = 0; i < sLen; i++) {
			char ch = s.charAt(i);
			sCount.put(ch, sCount.getOrDefault(ch, 0)+1);
			
			if(i >= pLen) {
				ch = s.charAt(i-pLen);
				if(sCount.get(ch) == 1) {
					sCount.remove(ch);
				} else {
					sCount.put(ch, sCount.get(ch)-1);
				}
			}
			
			// Compare both map
			if(sCount.equals(pCount)) {
				System.out.println("The matching starting index is : "+(i-pLen+1));
			}

		}
		System.out.println("***********************");	
	}
}
