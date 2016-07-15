package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution1 {

	/**
	 * (最大矩形)Given a 2D binary matrix filled with '0''s and '1''s, find the
	 * largest square containing all '1''s and return its area.
	 */
	// DP 记录一个即可 14ms
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] s = new int[matrix.length][matrix[0].length];// 以当前位置结尾的最大矩形
		s[0][0] = matrix[0][0] == '0' ? 0 : 1;
		int max = s[0][0];
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == '0') {
				s[i][0] = 0;
			} else {
				s[i][0] = 1;
				max = 1;
			}
		}
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == '0') {
				s[0][j] = 0;
			} else {
				s[0][j] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					s[i][j] = 0;
				} else {
					s[i][j] = Math.min(Math.min(s[i][j - 1], s[i - 1][j]), s[i - 1][j - 1]) + 1;
					if (s[i][j] > max)
						max = s[i][j];
				}
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		System.out.println(solution.maximalSquare(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } }));
		System.out.println(solution.maximalSquare(new char[][] { { '0', '0' } }));
	}
}
