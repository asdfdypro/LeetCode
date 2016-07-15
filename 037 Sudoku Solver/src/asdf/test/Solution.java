package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * (给出数独的解，只有单解)Write a program to solve a Sudoku puzzle by filling the
	 * empty cells.
	 * 
	 * Empty cells are indicated by the character '.'.
	 * 
	 * You may assume that there will be only one unique solution.
	 */

	private int[][] rowMap;
	private int[][] colMap;
	private int[][] m33Map;

	// 在i,j上填k是否解决
	private boolean search(char[][] board, int i, int j) {

		// 进位
		if (j > 8)
			return search(board, i + 1, 0);
		if (i > 8)
			return true;
		if (board[i][j] == '.') {
			for (int k = 1; k <= 9; k++) {
				if (rowMap[i][k] == 0 && colMap[j][k] == 0 && m33Map[(i / 3) * 3 + j / 3][k] == 0) {// 可行
					board[i][j] = (char) (k + 48);
					rowMap[i][k] = k;
					colMap[j][k] = k;
					m33Map[(i / 3) * 3 + j / 3][k] = k;
					if (search(board, i, j + 1))
						return true;
					board[i][j] = '.';
					rowMap[i][k] = 0;
					colMap[j][k] = 0;
					m33Map[(i / 3) * 3 + j / 3][k] = 0;
				}
			}
			return false;
		} else
			return search(board, i, j + 1);
	}

	public void solveSudoku(char[][] board) {

		rowMap = new int[9][10];
		colMap = new int[9][10];
		m33Map = new int[9][10];

		// 预处理
		int c;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					c = board[i][j] - '0';
					rowMap[i][c] = c;
					colMap[j][c] = c;
					m33Map[(i / 3) * 3 + j / 3][c] = c;
				}
			}
		}

		// 搜索
		search(board, 0, 0);	
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = { stringToCharArrays(".87654321"), stringToCharArrays("2........"),
				stringToCharArrays("3........"), stringToCharArrays("4........"),
				stringToCharArrays("5........"), stringToCharArrays("6........"),
				stringToCharArrays("7........"), stringToCharArrays("8........"),
				stringToCharArrays("9........") };

		solution.solveSudoku(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static char[] stringToCharArrays(String s) {
		char[] c = new char[s.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
		}
		return c;
	}

}
