package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (旋转有序序列查询)Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 */

	private int search(int[] nums, int target, int i, int j) {
		if(i>j)
			return -1;
		if (i == j)
			if (nums[i] == target)
				return i;
			else
				return -1;
		
		int m = (i + j) / 2;
		
		if (nums[m] < target) {
			if (nums[j] >= nums[m]) {// 右面完整
				if (target == nums[j])
					return j;
				if (target > nums[j])
					return search(nums, target, i, m - 1);// 向左搜索
			}
			return search(nums, target, m + 1, j); // 向右搜索
		} else if (nums[m] > target) {
			if (nums[i] <= nums[m]) {// 左面完整
				if (target == nums[i])
					return i;
				if (target < nums[i])
					return search(nums, target, m + 1, j); // 向右搜索
			}
			return search(nums, target, i, m - 1);// 向左搜索
		} else
			return m;
	}

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		return search(nums, target, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1,2 };
//		Arrays.sort(nums);
		for (int i = -5; i < 15; i++)
		{			
			System.out.println(solution.search(nums, i));
		}
	}
}
