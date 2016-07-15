package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	/**
	 * (四数和)Given an array S of n integers, are there elements a, b, c, and d in
	 * S such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target. Note: Elements in a quadruplet
	 * (a,b,c,d) must be in non-descending order. (ie,a ≤ b ≤ c ≤ d) The
	 * solution set must not contain duplicate quadruplets.
	 */
	

	
	//先求两两之和，再同2sum，注意量量和为target一半的情况
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

	

		return res;
	}

	public static void main(String[] args) {

		Solution2 solution = new Solution2();
		int[] a = { 0, 0, 0, 0 };
		int[] b = { 1, 0, -1, 0, -2, 2 };

		System.out.println(solution.fourSum(a, 0).size());
		System.out.println(solution.fourSum(b, 0).size());

	}
}