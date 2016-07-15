package asdf.test;

public class Solution {

	/**
	 * (小偷)After robbing those houses on that street, the thief has found
	 * himself a new place for his thievery so that he will not get too much
	 * attention. This time, all houses at this place are arranged in a circle.
	 * That means the first house is the neighbor of the last one. Meanwhile,
	 * the security system for these houses remain the same as for those in the
	 * previous street.
	 * 
	 * Given a list of non-negative integers representing the amount of money of
	 * each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 */

	// DP
	// 处理两头即可，0被选，尾不能选
	//考虑头是否选择的问题，同时由于选头，可能丢弃一些次优解，最后又没选这个结果的情况
	

	public int rob(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		//增加只有一家的情况
		if (nums.length == 1)
			return nums[0];
		
		int f = nums[0];// 带末尾
		int g = 0;// 不带末尾
		boolean fHas0 = true;// 是否选择头元素
		boolean gHas0 = false;// 是否选择头元素
		int t;
		boolean tHas0;
		for (int i = 1; i < nums.length; i++) {
			t = f;
			tHas0 = fHas0;
			f = g + nums[i];
			fHas0 = gHas0;
			if (t > g || (t == g && !tHas0)) {
				g = t;
				gHas0 = tHas0;
			}
		}
		if (fHas0) {
			f = f - nums[0];// 去掉头
		}
		int max = Math.max(g, f);

		//不含头的次优解
		f = nums[1];// 带末尾
		g = 0;// 不带末尾
		for (int i = 2; i < nums.length; i++) {
			t = f;
			f = g + nums[i];
			g = Math.max(g, t);
		}
		return Math.max(max, Math.max(g, f));
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rob(new int[] { 1, 2, 3, 3 }));
		System.out.println(solution.rob(new int[] { 2, 1, 1, 2 }));
		System.out.println(solution.rob(new int[] { 2 }));
		System.out.println(solution.rob(new int[] { 2, 1 }));
		System.out.println(solution.rob(new int[] { 1, 1, 1, 2 }));//相等的情况处理
		System.out
				.println(solution.rob(new int[] { 1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3 }));
		System.out.println(solution.rob(new int[] { 2, 2, 4, 3, 2, 5 }));//放弃次优解
	}
}