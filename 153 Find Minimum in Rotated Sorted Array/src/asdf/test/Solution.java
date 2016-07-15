package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (没有重复元素的旋转序列中，查找最小元素)Suppose a sorted array is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 */
	// 二分查找
	public int findMin(int[] nums) {
		int i = 0, j = nums.length - 1, m;
		// 完全有序
		if (nums[i] <= nums[j])
			return nums[i];

		while (i < j) {
			//两元素
			if (j - i == 1)
				return nums[i] < nums[j] ? nums[i] : nums[j];
			m = (i + j) / 2;
			if (nums[i] < nums[m]) {// 左面升序
				i = m;
			} else {
				j = m;
			}
		}
		return nums[i];

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] nums = { { 4, 5, 6, 7, 0, 1, 2 }, { 1 }, { 1, 2 }, { 2, 1 }, { 1, 2, 3 },
				{ 3, 1, 2 }, { 2, 3, 1 }, { 1, 2, 3, 4 } };
		for (int[] is : nums) {
			System.out.println(solution.findMin(is));
		}
	}
}
