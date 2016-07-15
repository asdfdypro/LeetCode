package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (收缩二维矩阵) Write an efficient algorithm that searches for a value in an m x
	 * n matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row.
	 * 
	 * For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [
	 * 
	 * [1, 3, 5, 7],
	 * 
	 * [10, 11, 16, 20],
	 * 
	 * [23, 30, 34, 50]
	 * 
	 * ]
	 * 
	 * Given target = 3, return true
	 */

	// 选择不大于的行
	public int searchRow(int[][] matrix, int target, int i, int j) {
		if (j <= i)
			if (matrix[i][0] > target)
				return i - 1;
			else
				return i;

		int m = (i + j) / 2;
		if (matrix[m][0] > target)
			return searchRow(matrix, target, i, m - 1);
		else if (matrix[m][0] < target)
			return searchRow(matrix, target, m + 1, j);
		else
			return m;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = searchRow(matrix, target, 0, matrix.length - 1);
		if (row < 0) {
			return false;
		}
		return Arrays.binarySearch(matrix[row], target) >= 0;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] matrix = { { 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 11, 13, 14, 15 }, { 21, 22, 24, 26 } };
		 for (int i = -2; i < 30; i++) {
		 System.out.print(i);
		 System.out.print("==");
		 boolean res = solution.searchMatrix(matrix, i);
		 System.out.println(res);
		 }
//		boolean res = solution.searchMatrix(matrix, 22);
//		System.out.println(res);

	}

}
