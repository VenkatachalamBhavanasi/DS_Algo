package ds.week5.weekwork;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/*
Given an integer n. Print first n elements of Recaman’s sequence.

Examples:
Input : n = 6
Output : 0, 1, 3, 6, 2, 7

Input  : n = 17
Output : 0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8
*/

public class RC_RecamanSeq {

	@Test
	public void example1() {
		int n = 6;
		generateRecamanSequence(n);
	}
	
	@Test
	public void example2() {
		int n = 17;
		generateRecamanSequence(n);
	}
/*
a(0) = 0,
if the number is not 
   already included in the sequence,
     a(n) = a(n - 1) - n 
else 
     a(n) = a(n-1) + n. 
*/
	private void generateRecamanSequence(int n) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.add(0);
		int cur = 0, prev = 0;
		for (int i = 1; i < n; i++) {
			cur = prev - i;
			if (cur < 0 || set.contains(cur))
				cur = prev + i;
			set.add(cur);
			prev = cur;
		}

		System.out.println(set);
	}

}
