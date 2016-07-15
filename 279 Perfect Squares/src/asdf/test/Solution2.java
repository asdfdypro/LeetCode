package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (完美平方和) Given a positive integer n, find the least number of perfect
	 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 */
	// DP 141ms
	public int numSquares(int n) {
		int squareLen = (int) Math.sqrt(n);

		int[] f = new int[n + 1];// i 最少的个数
		for (int i = 1; i < squareLen; i++) {
			f[i * i] = 1;
		}

		int[] square = new int[squareLen];// 平方
		for (int i = 0; i < squareLen; i++) {
			square[i] = (i + 1) * (i + 1);
		}

		numSquares(f, square, n);

		return f[n];
	}

	private void numSquares(int[] f, int[] square, int n) {
		if (f[n] > 0||n==0)
			return;
		f[n] = Integer.MAX_VALUE;
		int squareLen = (int) Math.sqrt(n);
		for (int i = 0; i < squareLen; i++) {
			numSquares(f, square, n - square[i]);
			if (f[n - square[i]] < f[n])
				f[n] = f[n - square[i]];
		}
		f[n]++;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		for (int i = 1; i < 15; i++) {
			System.out.println(i + "=" + solution.numSquares(i));
		}
		int i = 272;
		System.out.println(i + "=" + solution.numSquares(i));
	}
}
