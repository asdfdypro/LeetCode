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
	 * (螺旋输出矩阵)Given a matrix of m x n elements (m rows, n columns), return all
	 * elements of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix:
	 * 
	 * [ [ 1, 2, 3 ],
	 * 
	 * [ 4, 5, 6 ],
	 * 
	 * [ 7, 8, 9 ] ]
	 * 
	 * You should return [1,2,3,6,9,8,7,4,5].
	 */

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0)
			return res;
		int m = matrix.length, n = matrix[0].length;
		int i = 0, j = 0;
		int edge = 0;// 边
		boolean b;
		while (true) {
			b = true;
			while (j < n - edge) {// 行
				res.add(matrix[i][j++]);
				b = false;
			}
			if (b)
				break;
			j--;
			i++;

			b = true;
			while (i < m - edge) {// 列
				res.add(matrix[i++][j]);
				b = false;
			}
			if (b)
				break;
			i--;
			j--;

			b = true;
			while (j >= edge) {// 行
				res.add(matrix[i][j--]);
				b = false;
			}
			if (b)
				break;
			j++;
			i--;

			edge++;// 边界增加

			b = true;
			while (i >= edge) {// 列
				res.add(matrix[i--][j]);
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
		int[][] matrix =
//			{ { 1, 2 } }
		{{1,2,3},{3,4,5}}
//		 { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }
		;

		List<Integer> res = solution.spiralOrder(matrix);

		System.out.println(res.size());

		for (Integer n : res) {

			System.out.print(n + ",");
		}
	}

}
