package asdf.test;

public class Solution {

	/**
	 * (二维路径数目)A robot is located at the top-left corner of a m x n grid (marked
	 * 'Start' in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.!!!但是100结果会溢出。。。。
	 */

	// dp
	public int uniquePaths(int m, int n) {
		int[][] f = new int[m][n];

		f[0][0] = 1;
		for (int i = 1; i < m; i++) {
			f[i][0] = 1;
		}
		for (int j = 1; j < n; j++) {
			f[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}

		return f[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.uniquePaths(2, 1));

	}

}
