package ds.week3.classwork;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
*/
public class D1CW_JewelStone {
	/*
	 * Bruteforce
	 * Loop through the jewels and stones and count where ever there is match
	 * Keep adding the matches and return them
	 * Performance: Time -> o(n*m) Space o(1)
	 * 
	 */

	private int getStoneCount(String jewels, String stones) {
		int count = 0;
		for (int i = 0; i < jewels.length(); i++) {
			for (int j = 0; j < stones.length(); j++) {
				if (jewels.charAt(i) == stones.charAt(j))
					count++;
			}
		}
		return count;
	}

	/*
	 * Alternate Solution
	 * Goal: Find how many jewel stones together !!
	 * jewel (character) and how many (int) ?
	 * Create a map for the jewels
	 * Scan through the stones and check if there is jewel 
	 *   If you found it, add to your count
	 * 
	 * Performance: Time -> o(n+m) < o(2n) => o(n) Space o(n)
	 * 
	 */

	private int getStoneCountUsingHash(String jewels, String stones) {
		int count = 0;
		HashMap<Character, Integer> jewelStones = new HashMap<>();

		// O(n) -> 7
		for (int i = 0; i < stones.length(); i++) // find the map of jewels
			jewelStones.put(stones.charAt(i), jewelStones.getOrDefault(stones.charAt(i), 0) + 1);

		// o(m) -> 3
		for (int i = 0; i < jewels.length(); i++) {
			count += jewelStones.getOrDefault(jewels.charAt(i), 0);
		}

		return count;
	}

	@Test
	public void example1() {
		String jewels = "aA";
		String stones = "aAAbbbb";
		int stoneCount = getStoneCount(jewels, stones);
		System.out.println(stoneCount);
	}

	@Test
	public void example2() {
		String jewels = "z";
		String stones = "ZZ";
		int stoneCount = getStoneCount(jewels, stones);
		System.out.println(stoneCount);
	}

	@Test
	public void example3() {
		String jewels = "abc";
		String stones = "k";
		int stoneCount = getStoneCount(jewels, stones);
		System.out.println(stoneCount);
	}
}
