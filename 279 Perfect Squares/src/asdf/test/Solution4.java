package asdf.test;

import java.util.Arrays;

public class Solution4 {

	/**
	 * (完美平方和) Given a positive integer n, find the least number of perfect
	 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 */
	// Math 2ms
	public int numSquares(int n) {
		// If n is a perfect square, return 1.
		if (is_square(n)) {
			return 1;
		}

		// The result is 4 if and only if n can be written in the
		// form of 4^k*(8*m + 7). Please refer to
		// Legendre's three-square theorem.
		while ((n & 3) == 0) // n%4 == 0
		{
			n >>= 2;
		}
		if ((n & 7) == 7) // n%8 == 7
		{
			return 4;
		}

		// Check whether 2 is the result.
		int sqrt_n = (int) (int) Math.sqrt(n);
		for (int i = 1; i <= sqrt_n; i++) {
			if (is_square(n - i * i)) {
				return 2;
			}
		}

		return 3;
	}

	private boolean is_square(int n) {
		int sqrt_n = (int) Math.sqrt(n);
		return (sqrt_n * sqrt_n == n);
	}

	public static void main(String[] args) {
		Solution4 solution = new Solution4();
		for (int i = 1; i < 15; i++) {
			System.out.println(i + "=" + solution.numSquares(i));
		}
		int i = 272;
		System.out.println(i + "=" + solution.numSquares(i));
	}
}
