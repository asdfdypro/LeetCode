package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (在有序中获取合适的插入位置)Given a sorted array and a target value, return the index
	 * if the target is found. If not, return the index where it would be if it
	 * were inserted in order.
	 * 
	 * You may assume no duplicates in the array.
	 * 
	 * Here are few examples.
	 * 
	 * [1,3,5,6], 5 → 2
	 * 
	 * [1,3,5,6], 2 → 1
	 * 
	 * [1,3,5,6], 7 → 4
	 * 
	 * [1,3,5,6], 0 → 0
	 */

	private int search(int[] nums, int target, int i, int j) {
		if (i > j)
			return i ;//后插
		if (i == j)
			if (nums[i] < target)// 后插
				return i + 1;
			else
				return i;

		int m = (i + j) / 2;
		if (nums[m] < target)
			return search(nums, target, m + 1, j);
		else if (nums[m] > target)
			return search(nums, target, i, m - 1);
		else
			return m;
	}

	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		return search(nums, target, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,3};
		for (int i = -5; i < 15; i++) {
			int a = solution.searchInsert(nums, i);
			System.out.println(i+"="+a);
		}
	}
}
