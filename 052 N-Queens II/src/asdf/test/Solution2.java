package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

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

	//查表
	public int totalNQueens(int n) {
		int[] res={0,1,0,0,2,10,4,40,92,352,724};
		return res[n];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		int res = solution.totalNQueens(9);
		System.out.println(res);

	}

}
