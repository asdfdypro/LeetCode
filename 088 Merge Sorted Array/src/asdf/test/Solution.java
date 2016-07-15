package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (归并数组)Given two sorted integer arrays nums1 and nums2, merge nums2 into
	 * nums1 as one sorted array.
	 * 
	 * Note: You may assume that nums1 has enough space (size that is greater or
	 * equal to m + n) to hold additional elements from nums2. The number of
	 * elements initialized in nums1 and nums2 are m and n respectively.
	 */
//要合并到A中，从后往前合并
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int r=m+n-1;//合并位置
		m--;n--;
		while(m>=0&&n>=0){
			if(nums1[m]>nums2[n]){
				nums1[r--]=nums1[m--];
			}else{
				nums1[r--]=nums2[n--];
			}
		}
		while(n>=0){
			nums1[r--]=nums2[n--];
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums1 = { 7, 8, 9, 0, 0, 0 };
		int[] nums2 = { 4, 5, 6 };
		solution.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}