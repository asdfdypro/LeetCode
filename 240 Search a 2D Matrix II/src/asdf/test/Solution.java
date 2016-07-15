package asdf.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

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
		return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
	}

	private boolean searchMatrix(int[][] matrix, int target, int i, int j, int k, int l) {
		if (i > k || j > l)
			return false;

		int m = (i + k) / 2, n = (j + l) / 2;
		if (matrix[m][n] == target)
			return true;
		if (matrix[m][n] > target)
			return searchMatrix(matrix, target, i, j, m - 1, n - 1)
					|| searchMatrix(matrix, target, m, j, k, n - 1)
					|| searchMatrix(matrix, target, i, n, m - 1, l);
		else
			return searchMatrix(matrix, target, m+1, n+1, k, l)
					|| searchMatrix(matrix, target, i, n+1, m, l)
					|| searchMatrix(matrix, target, m+1, j, k, n);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

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
