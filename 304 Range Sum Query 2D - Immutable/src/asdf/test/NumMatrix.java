package asdf.test;

public class NumMatrix {

	/**
	 * (矩阵求和) Given a 2D matrix matrix, find the sum of the elements inside the
	 * rectangle defined by its upper left corner (row1, col1) and lower right
	 * corner (row2, col2).
	 */
	// DP
	private int sum[][] = null;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		sum = new int[matrix.length][matrix[0].length];
		sum[0][0] = matrix[0][0];
		for (int i = 1; i < matrix.length; i++) {
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		}
		for (int j = 1; j < matrix[0].length; j++) {
			sum[0][j] = sum[0][j - 1] + matrix[0][j];
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (sum == null)
			return 0;
		if (row1 == 0 && col1 == 0)
			return sum[row2][col2];
		if (row1 == 0)
			return sum[row2][col2] - sum[row2][col1 - 1];
		if (col1 == 0)
			return sum[row2][col2] - sum[row1 - 1][col2];
		return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2]
				+ sum[row1 - 1][col1 - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
				{ 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };

		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));// 8
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2));// 11
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4));// 12

	}
}
