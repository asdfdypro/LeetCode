package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (输出螺旋矩阵)Given an integer n, generate a square matrix filled with elements
	 * from 1 to n2 in spiral order.
	 * 
	 * For example, Given n = 3, You should return the following matrix:
	 * 
	 * 
	 * [ 1, 2, 3 ]
	 * 
	 * [ 8, 9, 4 ]
	 * 
	 * [ 7, 6, 5 ]
	 */

	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if (n < 1) {
			return res;
		}
		int num = 1;
		int i = 0, j = 0;
		boolean b;
		while (true) {
			b = true;
			while (j<n&&res[i][j] == 0) {// 行
				res[i][j++] = num++;
				b = false;
			}
			if (b)
				break;
			j--;
			i++;

			b = true;
			while (i<n&&res[i][j] == 0) {// 列
				res[i++][j] = num++;
				b = false;
			}
			if (b)
				break;
			i--;
			j--;

			b = true;
			while (j>=0&&res[i][j] == 0) {// 行
				res[i][j--] = num++;
				b = false;
			}
			if (b)
				break;
			j++;
			i--;

			b = true;
			while (i>=0&&res[i][j] == 0) {// 列
				res[i--][j] = num++;
				b = false;
			}
			if (b)
				break;
			i++;
			j++;

		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] res = solution.generateMatrix(4);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				System.out.print(res[i][j] + ",");
			}
			System.out.println();
		}
	}

}
