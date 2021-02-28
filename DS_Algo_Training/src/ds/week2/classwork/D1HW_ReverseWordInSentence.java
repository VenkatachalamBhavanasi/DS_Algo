package ds.week2.classwork;

import org.junit.Test;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Input:  "I am doing great"
Output: "I ma gniod taerg"
 */
public class D1HW_ReverseWordInSentence {

	@Test
	public void example1() {
		String input = "I am doing great";
		System.out.println(reverseWordsInLine(input));
	}

	@Test
	public void example2() {
		String input = "Testing";
		System.out.println(reverseWordsInLine(input));
	}

	@Test
	public void example3() {
		String input = "";
		System.out.println(reverseWordsInLine(input));
	}

	/*
	 * split the input by spaces if number of words in the sentance is null or 1
	 * then simply return the input string if the length of the word is greater than
	 * one then reverse the string using 2 pointer once reversed appened it to the
	 * output string and return the output
	 */
	// Space Complexity= O[N]
	// Time Complexity= O[N]
	private String reverseWordsInLine(String input) {

		if (input.length() == 0)
			return input;

		String[] split = input.split(" ");
		String output = "";

		for (String str : split) {
			if (str.length() == 1)
				output += str + " ";
			else {
				char[] cArr = str.toCharArray();
				int left = 0, right = cArr.length - 1;
				while (left < right) {
					char c = cArr[left];
					cArr[left++] = cArr[right];
					cArr[right--] = c;
				}
				output += String.valueOf(cArr) + " ";
			}
		}

		return output.trim();
	}
}
