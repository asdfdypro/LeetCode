package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (全是1的最大矩形)Given a 2D binary matrix filled with 0's and 1's, find the
	 * largest rectangle containing all ones and return its area.
	 */

	//从一个点开始扩展
	// 	16 ms 
	public int maximalRectangle(char[][] matrix) {
		int rowLen = matrix.length;
		if (rowLen < 1)
			return 0;

		int colLen = matrix[0].length;
		
		int maxArea = 0;	

		int area, maxcol;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				//以i，j为定点
				//逐行扩展

				maxcol = colLen;// 能扩展到的最大列
				for (int k = i; k < rowLen; k++) {//行扩展

					if (matrix[k][j] =='0')
						break;// 行出现空格，行扩展停止

					int m = j + 1;
					for (; m < maxcol; m++) {//列扩展
						if (matrix[k][m] =='0')
							break;// 列出现空格
					}
					maxcol = m;

					// 计算面积
					m--;
					area = (m - j + 1) * (k - i + 1);
					if (area > maxArea)
						maxArea = area;
				}
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] height = { { '0', '1', '1' }, { '0', '1', '1' }, { '0', '0', '0' } };
		System.out.println(solution.maximalRectangle(height));

	}
}
