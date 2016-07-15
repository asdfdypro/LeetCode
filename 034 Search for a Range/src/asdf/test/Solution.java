package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (在有序中查询目标范围)Given a sorted array of integers, find the starting and
	 * ending position of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 */

	private int search(int[] nums, int target, int i, int j) {
		if (i > j)
			return -1;
		if (i == j)
			if (nums[i] == target)
				return i;
			else
				return -1;
		int m = (i + j) / 2;
		if (nums[m] < target)
			return search(nums, target, m + 1, j);
		else if (nums[m] > target)
			return search(nums, target, i, m - 1);
		else
			return m;
	}

	private int searchSmall(int[] nums, int target, int i, int j) {
		if (i == j)
			return i;
		int m = (i + j) / 2;// 两个直到i
		if (nums[m] != target)
			return searchSmall(nums, target, m + 1, j);
		else
			return searchSmall(nums, target, i, m);
	}

	private int searchBig(int[] nums, int target, int i, int j) {
		if (i == j)
			return i;
		int m = (i + j + 1) / 2;// 两个直到j
		if (nums[m] != target)
			return searchBig(nums, target, i, m - 1);
		else
			return searchBig(nums, target, m, j);
	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums.length > 0) {
			int m = search(nums, target, 0, nums.length - 1);
//			m = Arrays.binarySearch(nums, target);
			if (m >= 0) {
				res[0] = searchSmall(nums, target, 0, m);
				res[1] = searchBig(nums, target, m, nums.length - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 5, 7, 8 };
		for (int i = -5; i < 15; i++) {
			String a = Arrays.toString(solution.searchRange(nums, i));
			System.out.println(a);
		}
	}
}
