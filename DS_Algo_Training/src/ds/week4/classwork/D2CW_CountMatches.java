package ds.week4.classwork;

import org.junit.Test;

/*
 * You are given an integer n, the number of teams in a tournament that has rules.
 * 
 * If the n is odd, In the first round -> one of the team get a bye
 * if the n is even, each team competes with each other to be a clear winner
 * 
 * Find the total count of matches
 */
public class D2CW_CountMatches {
		
	@Test
	public void example1() {
		int teams = 10;
		System.out.println(countMatches(teams));
	}
	
	@Test
	public void example2() {
		int teams = 5;
		System.out.println(countMatches(teams));
	}
	
	@Test
	public void example3() {
		int teams = 1;
		System.out.println(countMatches(teams));
	}

	// Intialize your starting position of the recursion 
	private int countMatches(int teams) {
		if(teams < 2)
			return 0;
		
		return recursive(teams);
	}

	
	// Do the counting here
	private int recursive(int teams) {
		if(teams % 2 == 1 && teams > 1) 
			return recursive((teams-1)/2)+((teams-1)/2)+1;
		if(teams % 2 == 0 && teams > 1) 
			return recursive((teams)/2)+((teams)/2);
	
		return 0;
	}

}
