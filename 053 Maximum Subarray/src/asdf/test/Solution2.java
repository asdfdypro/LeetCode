package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

	/**
	 * (最大子串和)Find the contiguous subarray within an array (containing at least
	 * one number) which has the largest sum.
	 */

	// 分治
	private int maxSubArray(int[] nums, int i, int j) {
		if (i == j)
			return nums[i];
		int max;
		int m = (i + j) / 2;
		int maxL = maxSubArray(nums, i, m);
		int maxR = maxSubArray(nums, m + 1, j);
		max = maxL > maxR ? maxL : maxR;

		int maxl = Integer.MIN_VALUE;
		int t = 0;
		for (int k = m; k >= i; k--) {
			t += nums[k];
			if (t > maxl)
				maxl = t;
		}

		int maxr = Integer.MIN_VALUE;
		t = 0;
		for (int k = m + 1; k <= j; k++) {
			t += nums[k];
			if (t > maxr)
				maxr = t;
		}

		if (maxl > max) {
			max = maxl;
		}
		if (maxr > max) {
			max = maxr;
		}
		if (maxr + maxl > max) {
			max = maxl + maxr;
		}

		return max;
	}

	public int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] matrix =

		 { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		{ 2, -1, 3 };

		int es = solution.maxSubArray(matrix);

		System.out.println(es);

	}
}
