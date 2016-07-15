package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (含有相同元素旋转有序序列查询)Suppose a sorted array is rotated at some pivot unknown
	 * to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 */

	// 判断完成的方式发生变化！！！
	// 关键在m与i j相等的时候,两遍都有可能，两遍都要搜索

	private boolean search(int[] nums, int target, int i, int j) {
		if (i > j)
			return false;
		if (i == j)
			if (nums[i] == target)
				return true;
			else
				return false;

		int m = (i + j) / 2;

		if (nums[m] < target) {
			if (nums[j] == nums[m]) {// 两遍都要搜索
				return search(nums, target, i, m - 1) || search(nums, target, m + 1, j);
			} else if (nums[j] > nums[m]) {// 右面完整
				if (target == nums[j])
					return true;
				if (target > nums[j])
					return search(nums, target, i, m - 1);// 向左搜索
			}
			return search(nums, target, m + 1, j); // 向右搜索
		} else if (nums[m] > target) {
			if (nums[i] == nums[m]) {// 两遍都要搜索
				return search(nums, target, m + 1, j) || search(nums, target, i, m - 1);
			} else if (nums[i] < nums[m]) {// 左面完整
				if (target == nums[i])
					return true;
				if (target < nums[i])
					return search(nums, target, m + 1, j); // 向右搜索
			}
			return search(nums, target, i, m - 1);// 向左搜索
		} else
			return true;
	}

	public boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		return search(nums, target, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = 
//			{3,1};
			{ 1,1,3,1 };
		// Arrays.sort(nums);
		// for (int i = -5; i < 15; i++) {
		// System.out.println(solution.search(nums, i));
		// }
		System.out.println(solution.search(nums, 3));
	}
}