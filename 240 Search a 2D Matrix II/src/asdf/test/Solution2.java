package asdf.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

	/**
	 * (搜索二维有序矩阵) Write an efficient algorithm that searches for a value in an m
	 * x n matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom.
	 * 
	 * For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14,
	 * 17, 24], [18, 21, 23, 26, 30] ]
	 * 
	 * Given target = 5, return true.
	 * 
	 * Given target = 20, return false.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (col >= 0 && row <= matrix.length - 1) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				col--;
			} else if (target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.searchMatrix(new int[][] { { 1, 4, 7, 11, 15 },
				{ 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } }, 20));
		System.out.println(solution.searchMatrix(new int[][] { { 4 } }, 4));
		System.out.println(solution.searchMatrix(new int[][] { { 5 } }, 4));
		System.out.println(solution.searchMatrix(new int[][] { { 5 } }, 6));
		System.out.println(solution.searchMatrix(new int[][] { { 1, 1 } }, 2));
		System.out.println(solution.searchMatrix(new int[][] { { 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } }, 19));
	}
}
