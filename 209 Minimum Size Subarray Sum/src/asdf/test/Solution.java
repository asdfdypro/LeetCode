package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	/**
	 * (最短和子序列) Given an array of n positive integers and a positive integer s,
	 * find the minimal length of a subarray of which the sum ≥ s. If there
	 * isn't one, return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
	 * has the minimal length under the problem constraint.
	 * 
	 */
	// 两点
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int i = 0, j = 0;
		int minLen = Integer.MAX_VALUE;

		while (j < nums.length) {
			while (j < nums.length && sum < s)
				sum += nums[j++];
			if (sum >= s) {
				while (i <= j && sum >= s)
					sum -= nums[i++];
				if (j <= nums.length && j - i < minLen)
					minLen = j - i;
			} else {
				break;
			}
		}

		if (minLen == Integer.MAX_VALUE)
			return 0;
		else
			return minLen + 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.minSubArrayLen(7, new int[] { 2, 3, 1, 3, 1, 3 }));
		System.out.println(solution.minSubArrayLen(3, new int[] { 1, 1 }));
		System.out.println(solution.minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
		System.out
				.println(solution.minSubArrayLen(15, new int[] { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 }));// 需要break
		System.out.println(solution.minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 }));
	}
}