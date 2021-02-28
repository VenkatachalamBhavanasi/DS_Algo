package ds.week9.classwork;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class D1CW_Palindrome {
	@Test
	public void example1() {
		String s = "babu";
		boolean pal = isPalindrome(s);
		System.out.println(pal);
	}
	
	@Test
	public void example2() {
		String s = "aamm";
		boolean pal = isPalindrome(s);
		System.out.println(pal);
	}
	
	@Test
	public void example3() {
		String s = "aamma";
		boolean pal = isPalindrome(s);
		System.out.println(pal);
	}

	/*
	 * Convert the string to char array
	 * add each one of them into the set or map
	 * check if it is already exist -> remove
	 * if it does not exist -> add
	 * finally get the count of set 
	 * if it is o or 1 -> true else false
	 * 
	 */
	
	// Two Pass
	// Multiple Pass
	private boolean isPalindrome(String s) {
		char[] cha = s.toCharArray();
		int left=0, right =cha.length-1;
		Set<Character> set = new HashSet<>();
		while(left < right) {
			if(!set.add(cha[left])) {
				set.remove(cha[left]);
			}
			if(!set.add(cha[right])) {
				set.remove(cha[right]);
			}
			left++;
			right--;
		}
		return set.size() <=1;
	}
	// Time: O(n/2)
	// Space: Worst -> O(n) average -> O(n/2)
}
