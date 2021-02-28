package ds.week7.classwork;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class BubbleSort {
	
	@Test
	public void example1() {
		int[] data = {-2, 0, 12, -4, 13, 8, 11};
		int[] sorted = bubbleSort(data);
		System.out.println(Arrays.toString(sorted));
	}

	@Test
	public void example2() {
		int[] data = {1,2,3,4};
		int[] sorted = bubbleSort(data);
		System.out.println(Arrays.toString(sorted));
	}
	
	@Test
	public void example3() {
		int[] data = {4,4,4,4,4};
		int[] sorted = bubbleSort(data);
		System.out.println(Arrays.toString(sorted));
		//Arrays.sort(null);
		//Collections.sort(null);
	}
	
	/*
	 * Compare the adjacent and if the left > right -> move to right
	 * 
	 * 
	 */
	private int[] bubbleSort(int[] data) {
		int n = data.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n-i; j++) {
				// when to swap? only when left > right
				if(data[j-1] > data[j]) {
					// swap
					temp = data[j-1];
					data[j-1] = data[j];
					data[j] = temp;
				}
			}
		}
		
		return data;
	}

}
