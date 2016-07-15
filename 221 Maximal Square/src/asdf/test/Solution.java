package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (最大矩形)Given a 2D binary matrix filled with '0''s and '1''s, find the
	 * largest square containing all '1''s and return its area.
	 */
	// DP 24ms
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int max = 0;
		int[][] s = new int[matrix.length][matrix[0].length];// 以当前位置结尾的最大矩形
		int[][] c = new int[matrix.length][matrix[0].length];// 以当前位置结尾的上面连续1
		int[][] r = new int[matrix.length][matrix[0].length];// 以当前位置结尾的左面连续1
		s[0][0] = matrix[0][0] == '0' ? 0 : 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					s[i][j] = 0;
					c[i][j] = 0;
					r[i][j] = 0;
				} else {
					if (i > 0) {
						c[i][j] = c[i - 1][j] + 1;
					} else {
						c[i][j] = 1;
						s[i][j] = 1;
					}
					if (j > 0) {
						r[i][j] = r[i][j - 1] + 1;
					} else {
						r[i][j] = 1;
						s[i][j] = 1;
					}
					if (i > 0 && j > 0)
						s[i][j] = s[i - 1][j - 1] + 1;
					s[i][j] = Math.min(Math.min(r[i][j], c[i][j]), s[i][j]);
					if (s[i][j] > max)
						max = s[i][j];
				}

			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maximalSquare(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } }));
		System.out.println(solution.maximalSquare(new char[][] { { '0', '0' } }));
	}
}
