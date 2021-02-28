package ds.week4.classwork;

import org.junit.Test;

public class D1CW_ReverseString {
	
	String s = "";
	
	@Test
	public void example1() {
		String input = "hello";
		System.out.println(reverseString(input));
	}
	/*
	 * Psuedocode for recursion
	 * 1) Call recursively the substring from 0 to len-1
	 * 2) Get that last character and append to the String
	 * 3) Return the string concatenated
	 * 
	 * Note: The break should be when input length = 0
	 * 
	 */
	
	private String reverseString(String input) {
				
		// when input length = 0
		if(input.length() == 0)
			return input;
		
		// Get that last character and append to the String
		s = s + input.charAt(input.length()-1);
		
		//Call recursively the substring from 0 to len-1
		reverseString(input.substring(0, input.length()-1));
		
		return s;
	}

}
