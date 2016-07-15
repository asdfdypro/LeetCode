package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	/**
	 * (四数和)Given an array S of n integers, are there elements a, b, c, and d in
	 * S such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target. Note: Elements in a quadruplet
	 * (a,b,c,d) must be in non-descending order. (ie,a ≤ b ≤ c ≤ d) The
	 * solution set must not contain duplicate quadruplets.
	 */

	//同三数和
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		int i, j;
		int len = nums.length;
		for (int m = 0; m < len - 3; m++) {
			if (m > 0 && nums[m] == nums[m - 1])
				continue; // 加速
			for (int k = m + 1; k < len - 2; k++) {
				if (k > m + 1 && nums[k] == nums[k - 1])
					continue; // 加速
				i = k + 1;
				j = len - 1;
				while (i < j) {
					if (nums[i] + nums[j]  +nums[k]+nums[m]>target)
						do
							j--;
						while (i < j && j + 1 < len && nums[j] == nums[j + 1]);
					else if (nums[i] + nums[j]  +nums[k]+nums[m]<target)
						do
							i++;
						while (i < j && i - 1 > k && nums[i] == nums[i - 1]);
					else {
						List<Integer> ans = new ArrayList<Integer>();
						ans.add(nums[m]);
						ans.add(nums[k]);
						ans.add(nums[i]);
						ans.add(nums[j]);
						res.add(ans);
						// 继续
						while (i < j && nums[i] == nums[i + 1])
							i++;
						while (i < j && nums[j] == nums[j - 1])
							j--;
						i++;
						j--;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] a = { 0, 0, 0, 0 };
		int[] b = { 1, 0, -1, 0, -2, 2 };

		System.out.println(solution.fourSum(a, 0).size());
		System.out.println(solution.fourSum(b, 0).size());

	}
}