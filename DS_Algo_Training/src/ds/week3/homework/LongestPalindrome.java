package ds.week3.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:
Input: s = "a"
Output: 1
Example 3:
Input: s = "bb"
Output: 2
*/
public class LongestPalindrome {

	@Test
	public void example1() {
		String s = "abccccdd";
		Assert.assertEquals(7, findLongestPalindrome(s));
	}

	@Test
	public void example2() {
		String s = "a";
		Assert.assertEquals(1, findLongestPalindrome(s));
	}

	@Test
	public void example3() {
		String s = "bb";
		Assert.assertEquals(2, findLongestPalindrome(s));
	}
	
	@Test
	public void example4() {
		String s = "Aa";
		Assert.assertEquals(1, findLongestPalindrome(s));
	}
	
	@Test
	public void example5() {
		String s = "cccc";
		Assert.assertEquals(4, findLongestPalindrome(s));
	}

	//Pseudo Code
	/*
	 * Create a new hash set
	 * add each characters to the hash set
	 * if the character is already available in the set, remove it
	 * if the set has any characters, subtract it from the length of the string and add 1
	 * if the set has no characters, just return the length of the string
	 */
	//Space complexity: O[N]
	//Time complexity: O[N]
	private int findLongestPalindrome(String s) {
		Set<Character> set=new HashSet<>();
		
		for(char c: s.toCharArray())
			if(!set.add(c))
				set.remove(c);
		
		if(!set.isEmpty())
			return s.length()-set.size()+1;
		
		return s.length();
	}
}
