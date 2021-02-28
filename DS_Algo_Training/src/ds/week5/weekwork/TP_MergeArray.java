package ds.week5.weekwork;

import java.util.Arrays;

import org.junit.Test;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
*/

public class TP_MergeArray {
	
	@Test
	public void example1() {
		int[] nums1= {1,2,3,0,0,0};
		int[] nums2= {2,5,6};
		int m=3,n=3;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	@Test
	public void example2() {
		int[] nums1= {1};
		int[] nums2= {};
		int m=1,n=0;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	@Test
	public void example3() {
		int[] nums1= {4,5,6,0,0,0};
		int[] nums2= {1,2,3};
		int m=3,n=3;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind=m+n-1;
        m--;
        n--;
        
        while(m>=0 && n>=0){
            if(nums1[m]>=nums2[n])
                nums1[ind--]=nums1[m--];
            else
                nums1[ind--]=nums2[n--];
        }
        
        while(m>=0)
            nums1[ind--]=nums1[m--];
        
        while(n>=0)
            nums1[ind--]=nums2[n--];
    }
}
