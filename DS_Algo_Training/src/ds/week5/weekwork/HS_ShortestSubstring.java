package ds.week5.weekwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
Given a string comprised of lowercase letters in the range ascii[a-z], find the length shortest substring that contains at least one of each of the letters in the string.

Example
givenString = dabbcabcd
The list of all characters in the string is [a, b, c, d]. Two of the substrings that contain all letters are dabbc and abcd. The shortest substring that contains all of the letters is 4 characters long. Return 4 as the answer. 
*/

public class HS_ShortestSubstring {

	@Test
	public void example1() {
		String s = "dabbcabcd";
		Assert.assertEquals(4, shortString(s));
	}

	@Test
	public void example2() {
		String s = "xxyzzxwxxxxyzzz";
		Assert.assertEquals(5, shortString(s));
	}

	@Test
	public void example3() {
		String s = "xxxx";
		Assert.assertEquals(1, shortString(s));
	}

	@Test
	public void example4() {
		String s = "xyz";
		Assert.assertEquals(3, shortString(s));
	}

	/*
	 * Create 1 hash map and one hash set add all character to set -> to get unique
	 * characters in the string iterate through the string and add each character
	 * and its occurrence to the map once the map keyset has all the characters that
	 * are present in the set then find its length shrink the length of the
	 * substring until we get min length having the all characters occuring atleast
	 * once
	 */
	// Space: O[N]
	// Time: O[N*M]
	private int shortString(String s) {
		if (s.length() == 0)
			return s.length();
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		char[] carr = s.toCharArray();

		for (char ch : carr)
			set.add(ch);

		int start = 0, end = 0;
		int minLen = Integer.MAX_VALUE;
		while (end < carr.length) {
			map.put(carr[end], map.getOrDefault(carr[end], 0) + 1);

			while (map.keySet().equals(set)) {
				minLen = Math.min(minLen, end - start + 1);

				if (map.get(carr[start]) == 1)
					map.remove(carr[start]);
				else
					map.put(carr[start], map.get(carr[start]) - 1);

				start++;
			}
			end++;
		}

		return minLen;
	}
}
