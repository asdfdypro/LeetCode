package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (爬楼梯)You are climbing a stair case. It takes n steps to reach to the top.
	 * 
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways
	 * can you climb to the top?
	 */
	// DP
	public int climbStairs(int n) {
		int a = 0;
		int b = 1;
		int c=0;
		while (n-- > 0) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 10; i++) {
			System.out.println(solution.climbStairs(i));
		}
	}
}
