package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (最长递增序列) Given an unsorted array of integers, find the length of longest
	 * increasing subsequence.
	 * 
	 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
	 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there
	 * may be more than one LIS combination, it is only necessary for you to
	 * return the length.
	 * 
	 * Your algorithm should run in O(n2) complexity.
	 * 
	 * Follow up: Could you improve it to O(n log n) time complexity?
	 */
	// 首先建立有序数组dp,
	// 如果nums[i]>max{dp},就将nums[i]加入数组dp,行成一个更长的增长子序列，
	// 否则用nums[i]更新数组中前面第一个比他大的数，提升数组长度继续提升的潜质。
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}

		return len;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.lengthOfLIS(new int[] {}));
		System.out.println(solution.lengthOfLIS(new int[] { 1 }));
		System.out.println(solution.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(solution.lengthOfLIS(new int[] { 1, 1, 1 }));
		System.out.println(solution.lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
	}
}
