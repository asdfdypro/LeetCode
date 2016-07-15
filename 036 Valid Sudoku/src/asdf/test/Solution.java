package asdf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

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

	public boolean isValidSudoku(char[][] board) {

		Map<Character, Character> checkMap;

		// 行
		for (int i = 0; i < 9; i++) {
			checkMap = new HashMap<Character, Character>(9);
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (checkMap.get(board[i][j]) != null)
						return false;
					else
						checkMap.put(board[i][j], board[i][j]);
				}
			}
		}
		// 列
		for (int i = 0; i < 9; i++) {
			checkMap = new HashMap<Character, Character>(9);
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (checkMap.get(board[j][i]) != null)
						return false;
					else
						checkMap.put(board[j][i], board[j][i]);
				}
			}
		}

		// 方格
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				checkMap = new HashMap<Character, Character>(9);
				for (int k = i; k < i + 3; k++) {
					for (int m = j; m < j + 3; m++) {
						if (board[k][m] != '.') {
							if (checkMap.get(board[k][m]) != null)
								return false;
							else
								checkMap.put(board[k][m], board[k][m]);
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
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
