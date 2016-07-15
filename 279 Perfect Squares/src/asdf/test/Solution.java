package asdf.test;

public class Solution {

	/**
	 * (完美平方和) Given a positive integer n, find the least number of perfect
	 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 */
	//搜索  超时
	public int numSquares(int n) {
		int squareLen = (int) Math.sqrt(n);
		int[] square = new int[squareLen];
		for (int i = 0; i < squareLen; i++) {
			square[i] = (i + 1) * (i + 1);
		}
		int[] min = { Integer.MAX_VALUE };
		for (int i = 0; i < squareLen; i++) {
			numSquares(min, square, 1, n - square[i]);
		}
		return min[0];
	}

	private void numSquares(int[] min, int[] square, int work, int n) {
		if (n == 0) {
			if (work < min[0])
				min[0] = work;
			return;
		}
		if (work > min[0])// 剪枝
			return;
		for (int i = 0; i < (int) Math.sqrt(n); i++) {
			numSquares(min, square, work + 1, n - square[i]);
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i < 15; i++) {
			System.out.println(i + "=" + solution.numSquares(i));
		}
		int i = 272;
		System.out.println(i + "=" + solution.numSquares(i));
	}
}
