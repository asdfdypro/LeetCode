package asdf.test;

import java.util.Arrays;

public class Solution3 {

	/**
	 * (完美平方和) Given a positive integer n, find the least number of perfect
	 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 */
	// DP 离散背包 使用循环实现  73ms
	public int numSquares(int n) {
		int[] d = new int[n + 1];
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (j * j <= i) {
				if (j * j == i) {
					min = 1;
					break;
				}
				min = Math.min(min, d[i - j * j] + 1);
				++j;
			}
			d[i] = min;
		}
		return d[n];
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		for (int i = 1; i < 15; i++) {
			System.out.println(i + "=" + solution.numSquares(i));
		}
		int i = 272;
		System.out.println(i + "=" + solution.numSquares(i));
	}
}
