package asdf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	/**
	 * (当前数独状态是否合理，不一定有解)Determine if a Sudoku is valid, according to: Sudoku
	 * Puzzles - The Rules.
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * A valid Sudoku board (partially filled) is not necessarily solvable. Only
	 * the filled cells need to be validated.
	 */

	// 改用数组记录 快了5秒
	public boolean isValidSudoku(char[][] board) {

		int[] check = new int[9];
		int c;

		// 行
		for (int i = 0; i < 9; i++) {
			Arrays.fill(check, 0);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					c = board[i][j] - '0' - 1;
					if (check[c] != 0)
						return false;
					else
						check[c] = 1;
				}
			}
		}
		// 列
		for (int i = 0; i < 9; i++) {
			Arrays.fill(check, 0);
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					c = board[j][i] - '0' - 1;
					if (check[c] != 0)
						return false;
					else
						check[c] = 1;
				}
			}
		}

		// 方格
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(check, 0);
				for (int k = i; k < i + 3; k++) {
					for (int m = j; m < j + 3; m++) {
						if (board[k][m] != '.') {
							c = board[k][m] - '0' - 1;
							if (check[c] != 0)
								return false;
							else
								check[c] = 1;
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		char[][] board = { stringToCharArrays(".87654321"), stringToCharArrays("2........"),
				stringToCharArrays("3........"), stringToCharArrays("4........"),
				stringToCharArrays("5........"), stringToCharArrays("6........"),
				stringToCharArrays("7........"), stringToCharArrays("8........"),
				stringToCharArrays("9........") };

		boolean a = solution.isValidSudoku(board);
		System.out.println(a);

	}

	private static char[] stringToCharArrays(String s) {
		char[] c = new char[s.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
		}
		return c;
	}

}
