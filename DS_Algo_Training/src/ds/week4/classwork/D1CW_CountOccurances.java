package ds.week4.classwork;

import org.junit.Test;

public class D1CW_CountOccurances {
	
	/*
	 * When to use recursion?
	 *  = When you see same functionality repeated again and again to solve problems (sub problems)
	 *  = 2 Rules 
	 *  	-> What to be recursed (input)
	 *  	-> When to break the recursion
	 *  = Recursion are performance oriented and it is decent approach when do not have best solution 
	 * 
	 */
	
	@Test
	public void example1() {
		String s1 = "welcome to world, to do something great to everyone";
		String s2 = "to";
		//bruteForce(k);
		System.out.println(recursive(s1, s2));
	}

	// welcome to world, to do something great to everyone
	
	private int recursive(String s1, String s2) {
		if(!s1.contains(s2))
			return 0;
		
		return recursive(s1.replaceFirst(s2, ""), s2) + 1;

	}

}
