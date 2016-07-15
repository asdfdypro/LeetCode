package asdf.test;

import java.util.Arrays;

public class Solution {

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
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		
		int res = 1;
		int[] f = new int[nums.length];
		f[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && f[j] > f[i])
					f[i] = f[j];
			}
			f[i]++;
			if (f[i] > res)
				res = f[i];
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.lengthOfLIS(new int[] {}));
		System.out.println(solution.lengthOfLIS(new int[] { 1}));
		System.out.println(solution.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(solution.lengthOfLIS(new int[] { 1, 1, 1 }));
		System.out.println(solution.lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
	}
}
