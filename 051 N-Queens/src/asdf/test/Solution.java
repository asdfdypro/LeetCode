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
	 * (输出n皇后的全部结果) The n-queens puzzle is the problem of placing n queens on an
	 * n×n chessboard such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 */

	private List<String> printWork(int[] work) {
		List<String> res = new ArrayList<String>();
		StringBuffer sb;//		StringBuffer 省2ms
		for (int i = 0; i < work.length; i++) {
			sb = new StringBuffer();
			for (int j = 0; j < work.length; j++) {
				if (j == work[i])
					sb.append('Q');
				else
					sb.append('.');
			}
			res.add(sb.toString());
		}
		return res;
	}

	private List<List<String>> nQueen(int[] c, int[] rc, int[] cr, int[] work, int i) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (i == work.length) {
			res.add(printWork(work));
		} else {
			int rcn, crn;
			for (int j = 0; j < work.length; j++) {// 列
				rcn = i + j;
				crn = i - j + work.length - 1;
				if (c[j] == 0 && rc[rcn] == 0 && cr[crn] == 0) {
					c[j] = 1;
					rc[rcn] = 1;
					cr[crn] = 1;
					work[i] = j;
					res.addAll(nQueen(c, rc, cr, work, i + 1));
					c[j] = 0;
					rc[rcn] = 0;
					cr[crn] = 0;
				}
			}
		}
		return res;
	}

	public List<List<String>> solveNQueens(int n) {
		if (n < 1)
			return new ArrayList<List<String>>();

		int[] c = new int[n];// 列
		int[] rc = new int[n + n - 1];// 左下右上
		int[] cr = new int[n + n - 1];// 左上右下
		int[] work = new int[n];
		return nQueen(c, rc, cr, work, 0);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		List<List<String>> res = solution.solveNQueens(4);

		System.out.println(res.size());

		for (List<String> list : res) {
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println("=====================");
		}
	}

}
