package ds.week2.homework;

import java.util.Arrays;

import org.hamcrest.core.Is;
import org.junit.Test;

/*
Find if the given anagram is substring of the input string. Solve using sliding window.
Example 1:
String input="acbbabccaabcab";
String anagram="abc";
Output: True
Explanation: Substring(0,2) is anagram of "abc"

Example 2:
String input="acbbabccaabcab";
String anagram="abd";
Output: false
*/

public class AnagramSubstring {

	@Test
	public void example1() {
		String input="acbbabccaabcab";
		String anagram="abc";
		System.out.println(isAnagramAvailable(input, anagram));
		
	}
	
	@Test
	public void example2() {
		String input="acbbabccaabcab";
		String anagram="abd";
		System.out.println(isAnagramAvailable(input, anagram));
		
	}
	
	@Test
	public void example3() {
		String input="abfgkcedel";
		String anagram="eecd";
		System.out.println(isAnagramAvailable(input, anagram));
		
	}
	
	//Pseudo Code
	/*
	 Create 2 array of size 26
	 I'll get the occurrence of the characters in the anagram and store it in the anagram ascii array
	 first i'll add first k  characters (where k is size of anagram string) from the input string to ascii array
	 now i'll compare both anagram array and input array, if matches return true else remove first element from the window and add next element to window
	 */
	
	private boolean isAnagramAvailable(String input,String anagram) {
		//For this problem we are considering only lower case alphabets in both the input string
		//As there are only 26 lower case alphabets, we are creating 2 arrays with size 26 for both input and anagram string
		int[] inputArr=new int[26];	
		int[] anagramArr=new int[26];
		
		for(char c:anagram.toCharArray())
			anagramArr[c-'a']++;	//Initially we are adding occurrences of characters in anagram string
		//c represent each character in the string. each character return its corresponding ascii value. say if 'a' it is 97 and 'c' it is 99 and so on..
		//as we created only array with 26 size, we are subtracting 97 (ascii value of 'a') from each character in the string and getting the index
		//say for abc, we get 'a','b','c' and its corresponding ascii are 97,98 and 99 respectively
		//when subtracting 97 from each we get 0,1,2 and we are incrementing count according to the occurrence
		
		int start=0,end=0;
		
		while(end<input.length()) {
			inputArr[input.charAt(end++)-'a']++; // we add the occurrence of the character as stated above
			
			if(end>anagram.length())	//substring in the input string should be equal to anagram length, if it goes above that we subtract start character from the window
				inputArr[input.charAt(start++)-'a']--;
			
			if(Arrays.equals(inputArr, anagramArr))	//we compare both array. if occurrence of both matches, it return true.
				return true;
		}
		
		return false;
	}
}
