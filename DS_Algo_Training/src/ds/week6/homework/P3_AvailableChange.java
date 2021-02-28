package ds.week6.homework;

import java.util.ArrayDeque;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of N integers where Ai denotes the currency of note that the i-th person has. The possible currencies are 5, 10 and 20. All the N people are standing in a queue waiting to buy an ice-cream from X which costs Rs 5. Initially, X has an initial balance of 0. Check if X will be able to provide change to every people who are waiting to buy an ice-cream.

Examples:
Input:a[] = {5, 5, 5, 10, 20}
Output: true
When the fourth person chance comes to buy an ice-cream, X has three Rs 5 change, hence X gives him 1, and now when the fifth person comes to buy the ice-cream, X has two Rs 5 and one Rs 10 note, hence he gives him one Rs 10 and one Rs 5 note.

Input: a[] = {5, 10, 10, 20}
Output: false
*/

public class P3_AvailableChange {

	@Test
	public void example1() {
		int[] nums = { 5, 5, 5, 10, 20 };
		Assert.assertEquals(true, isChangeAvailable(nums));
	}

	@Test
	public void example2() {
		int[] nums = { 5, 10, 10, 20 };
		Assert.assertEquals(false, isChangeAvailable(nums));
	}

	private boolean isChangeAvailable(int[] nums) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		Arrays.stream(nums).forEach(each -> queue.offer(each));
		int fiveCnt = 0;
		int tenCnt = 0;

		for (int i = 0; i < nums.length; i++) {
			int cur = queue.poll();

			if (cur == 5)
				fiveCnt++;
			else if (cur == 10) {
				if (fiveCnt > 0) {
					fiveCnt--;
					tenCnt++;
				} else
					return false;
			} else {
				if (fiveCnt > 0 && tenCnt > 0) {
					fiveCnt--;
					tenCnt--;
				} else if (fiveCnt > 2)
					fiveCnt -= 3;
				else
					return false;
			}
		}

		return true;
	}
}
