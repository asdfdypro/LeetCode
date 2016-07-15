package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution2 {

	/**
	 * (全是1的最大矩形)Given a 2D binary matrix filled with 0's and 1's, find the
	 * largest rectangle containing all ones and return its area.
	 */

	// 每列单独看，每个连续的1可以看做是一个长条，题目变为连续长条中组成的最大矩形
	// 计算每行对应的长条，每行采用84的方法计算
	// 31 ms
	public int maximalRectangle(char[][] matrix) {
		int rowLen = matrix.length;
		if (rowLen < 1)
			return 0;

		int colLen = matrix[0].length;
		int[][] f = new int[rowLen][colLen];// 每行的矩形高度
		int maxArea = 0, area;

		for (int j = 0; j < colLen; j++) {
			if (matrix[rowLen - 1][j] == '1')
				f[rowLen - 1][j] = 1;
			for (int i = rowLen - 2; i >= 0; i--) {
				if (matrix[i][j] == '1')
					f[i][j] = f[i + 1][j] + 1;
			}
		}
		for (int i = 0; i < rowLen; i++) {
			area = largestRectangleArea(f[i]);
			if (area > maxArea)
				maxArea = area;
		}

		return maxArea;
	}

	public int largestRectangleArea(int[] height) {
		int maxRectangle = 0;
		Stack<Integer> workStack = new Stack<Integer>();
		int tmp;
		for (int i = 0; i < height.length; i++) {
			if (workStack.isEmpty() || height[i] > height[workStack.peek()])
				workStack.push(i);
			else {
				tmp = workStack.pop();
				tmp = height[tmp] * (workStack.empty() ? i : i - workStack.peek() - 1);

				if (tmp > maxRectangle)
					maxRectangle = tmp;
				i--;
			}
		}
		while (!workStack.isEmpty() && height[workStack.peek()] > 0) {
			tmp = workStack.pop();
			tmp = height[tmp]
					* (workStack.empty() ? height.length : height.length - workStack.peek() - 1);

			if (tmp > maxRectangle)
				maxRectangle = tmp;
		}

		return maxRectangle;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		char[][] height = { { '0', '1', '1' }, { '0', '1', '1' }, { '0', '1', '1' } };
		System.out.println(solution.maximalRectangle(height));

	}
}
