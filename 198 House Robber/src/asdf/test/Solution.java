package asdf.test;

public class Solution {

	/**
	 * (小偷)You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed, the only constraint
	 * stopping you from robbing each of them is that adjacent houses have
	 * security system connected and it will automatically contact the police if
	 * two adjacent houses were broken into on the same night.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 */

	// DP
	public int rob(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int f = nums[0];// 带末尾
		int g = 0;// 不带末尾
		int t;
		for (int i = 1; i < nums.length; i++) {
			t = f;
			f = g + nums[i];
			g = Math.max(t, g);
		}

		return Math.max(f, g);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rob(new int[] { 1, 2, 3, 3 }));
		System.out.println(solution.rob(new int[] { 2, 1, 1, 2 }));
	}
}