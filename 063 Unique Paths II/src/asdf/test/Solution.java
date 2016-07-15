package asdf.test;

public class Solution {

	/**
	 * (二维路径数目，含路障)A robot is located at the top-left corner of a m x n grid
	 * (marked 'Start' in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * Follow up for "Unique Paths":
	 * 
	 * Now consider if some obstacles are added to the grids. How many unique
	 * paths would there be?
	 * 
	 * An obstacle and empty space is marked as 1 and 0 respectively in the
	 * grid.
	 * 
	 * For example,
	 * 
	 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
	 * 
	 * [ [0,0,0],
	 * 
	 * [0,1,0],
	 * 
	 * [0,0,0] ]
	 * 
	 * The total number of unique paths is 2.
	 * 
	 * Note: m and n will be at most 100.
	 */

	// dp
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1)
			return 0;
		
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] f = new int[m][n];

		f[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] > 0)
				f[i][0] = 0;
			else
				f[i][0] = f[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] > 0)
				f[0][j] = 0;
			else
				f[0][j] = f[0][j - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] > 0)
					f[i][j] = 0;
				else
					f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}

		return f[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));

	}

}
