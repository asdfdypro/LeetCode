package asdf.test;

public class Solution {

	/**
	 * (二维路径 和最小)Given a m x n grid filled with non-negative numbers, find a
	 * path from top left to bottom right which minimizes the sum of all numbers
	 * along its path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */

	// dp
	public int minPathSum(int[][] grid) {

		int m = grid.length, n = grid[0].length;
		int[][] f = new int[m][n];

		f[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			f[i][0] = f[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			f[0][j] = f[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = f[i][j - 1] > f[i - 1][j] ? f[i - 1][j] : f[i][j - 1];
				f[i][j] += grid[i][j];
			}
		}

		return f[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] obstacleGrid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println(solution.minPathSum(obstacleGrid));

	}

}
