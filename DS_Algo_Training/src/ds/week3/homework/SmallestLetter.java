package ds.week3.homework;

import org.junit.Assert;
import org.junit.Test;

/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
*/

public class SmallestLetter {

	@Test
	public void example1() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'a';
		Assert.assertEquals('c', nextGreatestLetter(letters, target));
	}

	@Test
	public void example2() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'k';
		Assert.assertEquals('c', nextGreatestLetter(letters, target));
	}

	@Test
	public void example3() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'c';
		Assert.assertEquals('f', nextGreatestLetter(letters, target));
	}

	@Test
	public void example4() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'd';
		Assert.assertEquals('f', nextGreatestLetter(letters, target));
	}

	@Test
	public void example5() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'g';
		Assert.assertEquals('j', nextGreatestLetter(letters, target));
	}

	@Test
	public void example6() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'j';
		Assert.assertEquals('c', nextGreatestLetter(letters, target));
	}

	public char nextGreatestLetter(char[] letters, char target) {
		int left = 0, right = letters.length - 1;
		int mid = 0;
		char res = letters[0];
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (letters[mid] > target) {
				res = letters[mid];
				right = mid - 1;
			} else
				left = mid + 1;
		}
		return res;
	}
}
