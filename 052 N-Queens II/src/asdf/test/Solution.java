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
	 * (输出n皇后的全部结果数目) The n-queens puzzle is the problem of placing n queens on
	 * an n×n chessboard such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 */

	private int nQueen(int[] c, int[] rc, int[] cr, int[] work, int i) {
		if (i == work.length) {
			return 1;
		} else {
			int res = 0;
			int rcn, crn;
			for (int j = 0; j < work.length; j++) {// 列
				rcn = i + j;
				crn = i - j + work.length - 1;
				if (c[j] == 0 && rc[rcn] == 0 && cr[crn] == 0) {
					c[j] = 1;
					rc[rcn] = 1;
					cr[crn] = 1;
					work[i] = j;
					res += nQueen(c, rc, cr, work, i + 1);
					c[j] = 0;
					rc[rcn] = 0;
					cr[crn] = 0;
				}
			}
			return res;
		}

	}

	public int totalNQueens(int n) {
		if (n < 1)
			return 0;

		int[] c = new int[n];// 列
		int[] rc = new int[n + n - 1];// 左下右上
		int[] cr = new int[n + n - 1];// 左上右下
		int[] work = new int[n];
		return nQueen(c, rc, cr, work, 0);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		for (int i = 0; i < 11; i++) {

			int res = solution.totalNQueens(i);
			System.out.print(res +",");
		}

	}

}
