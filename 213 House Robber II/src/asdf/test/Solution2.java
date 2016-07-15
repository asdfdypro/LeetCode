package asdf.test;

public class Solution2 {

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
	//相当于头尾两家互斥，分别计算不含头，不含尾部的值即可
	

	public int rob(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		if (nums.length == 1)
			return nums[0];
		
		if (nums.length == 2)
			return Math.max(nums[0],nums[1]);
		
		int f0 = nums[0];// 带末尾
		int g0 = 0;// 不带末尾
		int f1=nums[1];
		int g1=0;				
		int t;
		
		t = f0;
		f0 = g0 + nums[1];
		g0 = Math.max(g0, t);		
		for (int i = 2; i < nums.length-1; i++) {
			t = f0;
			f0 = g0 + nums[i];
			g0 = Math.max(g0, t);
			
			t = f1;
			f1 = g1 + nums[i];
			g1 = Math.max(g1, t);			
		}
		t = f1;
		f1 = g1 + nums[nums.length-1];
		g1 = Math.max(g1, t);		
				
		return Math.max(Math.max(g0, f0), Math.max(g1, f1));
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
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