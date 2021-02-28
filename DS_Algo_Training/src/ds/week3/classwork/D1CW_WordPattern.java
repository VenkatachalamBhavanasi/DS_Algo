package ds.week3.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/*
Given a pattern and a string find if it follows the pattern
eg 1:
Pattern="abba" s="dog cat cat dog"
Output=true

Pattern="abba" s="dog cat cat fish"
Output=false
 */
public class D1CW_WordPattern {
	/*
	 * Hashing PsuedoCode
	 *
	 * Pattern -> Character (Key) : String (Value) && 
	 * Data -> String (Key) : Character (Value)
	 * 
	 * Iterate through each word of String and corresponding character in Pattern
	 * 	1) If it is new (no entry) on both -> add to the respective map 
	 *  2) If the character is not there but String in map -> return false
	 *  3) If the character is there in map, then get the corresponding value & compare
	 *  	a) If it is not same as expected -> return false
	 *  
	 *  If all above conditions passed through then return true
	 * 
	 */
	
	// Performance : Time -> O(n)
	// Space: O(3n)
	private boolean isPatternMatches(String pattern, String s) {
		Map<Character, String> mapC = new HashMap<>();
		Map<String, Character> mapS= new HashMap<>();
		String[] words = s.split(" ");
		
		if(words.length != pattern.length())
			return false;
		
		for (int i = 0; i < words.length; i++) { // -> Every iteration -> 15 ms -> 100*15
			char c = pattern.charAt(i);
			String w = words[i];
			if(!mapC.containsKey(c)) {
				if(!mapS.containsKey(w)) {
					mapC.put(c, w);
					mapS.put(w,c);
				} else {
					return false;
				}
			} else {
				String mappedWord = mapC.get(c);
				if(!mappedWord.equals(w))
					return false;
			}
		}
		return true;
	}

	@Test
	public void example1() {
		String pattern = "abba";
		String input = "dog cat cat dog";
		boolean matches = isPatternMatches(pattern, input);
		System.out.println(matches);
	}

	@Test
	public void example2() {
		String pattern = "abba";
		String input = "dog cat cat fish";
		boolean matches = isPatternMatches(pattern, input);
		System.out.println(matches);
	}

	@Test
	public void example3() {
		String pattern = "abc";
		String input = "hello world world";
		boolean matches = isPatternMatches(pattern, input);
		System.out.println(matches);
	}
	
	@Test
	public void example4() {
		String pattern = "abcd";
		String input = "hello world india";
		boolean matches = isPatternMatches(pattern, input);
		System.out.println(matches);
	}
}
