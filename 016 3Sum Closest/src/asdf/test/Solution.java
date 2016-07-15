package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	/**
	 * (三数和为最接近目标)Given an array S of n integers, find three integers in S such
	 * that the sum is closest to a given number, target. Return the sum of the
	 * three integers. You may assume that each input would have exactly one
	 * solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */

	public int threeSumClosest(int[] nums, int target) {
		int res = Integer.MAX_VALUE;

		Arrays.sort(nums);

		int i, j, m;
		int len = nums.length;
		for (int k = 0; k < len - 2; k++) {
			if (k > 0 && nums[k] == nums[k - 1])
				continue; // 加速
			i = k + 1;
			j = len - 1;
			while (i < j) {
				m = nums[i] + nums[j] + nums[k];
				if (m == target)
					return target;
				else if (m > target)
					do
						j--;
					while (i < j && j + 1 < len && nums[j] == nums[j + 1]);
				else
					do
						i++;
					while (i < j && i - 1 > k && nums[i] == nums[i - 1]);
				if (Math.abs(target - m) < Math.abs(res))
					res = target - m;
			}
		}

		return target - res;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] a = { 1, 1, 1, 0 };
		int[] b = { -1, 0, 1, 2, -1 };
		int[] c = { -1, 0, 1, 2, -1, -4, -1, 2, -2, 1, 3 };
		int[] d = { -5, 4, 5, -1, 3, 7, -8, -4, 7, -5, -4, 0, -9, -7, 7, -4, 1, -2, 3, 7, 4, 0, -3,
				3, -9, 5 };

		System.out.println(solution.threeSumClosest(a, -100));
		// System.out.println(solution.threeSumClosest(b, 0));
		// System.out.println(solution.threeSumClosest(c, 0));
		// System.out.println(solution.threeSumClosest(d, 0));
	}
}