package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (设置指定行列为0) Given a m x n matrix, if an element is 0, set its entire row
	 * and column to 0. Do it in place.
	 */
	// 使用首行首列记录是否置0
	public void setZeroes(int[][] matrix) {

		// 记录首行首列状态
		boolean r0 = false, c0 = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				c0 = true;
				break;
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				r0 = true;
				break;
			}
		}

		// 用首行首列存储状态
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// 填充
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		

		
		// 考虑首行
		if (c0)
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		if (r0)
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] matrix = { { 1, 2, 3, 4 }, { 1, 2, 0, 4 }, { 1, 0, 3, 4 }, { 1, 2, 3, 4 } };

		printMatrix(matrix);

		solution.setZeroes(matrix);

		printMatrix(matrix);

	}

	private static void printMatrix(int[][] matrix) {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
