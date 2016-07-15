package asdf.test;

public class Solution {

	/**
	 * (共同前缀)Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
	 * bitwise AND of all numbers in this range, inclusive.
	 * 
	 * For example, given the range [5, 7], you should return 4.
	 */
	// 存在错误特例
	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m = m >> 1;
			n = n >> 1;
			count++;
		}
		return m << count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.rangeBitwiseAnd(7, 4));
		System.out.println(solution.rangeBitwiseAnd(96, 112));
	}
}