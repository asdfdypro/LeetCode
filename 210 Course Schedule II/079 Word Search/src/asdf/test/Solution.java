package asdf.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (搜索单词) Given a 2D board and a word, find if the word exists in the grid.
	 * 
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 * 
	 * For example, Given board =
	 * 
	 * [ ['A','B','C','E'],
	 * 
	 * 
	 * ['S','F','C','S'],
	 * 
	 * ['A','D','E','E']
	 * 
	 * ]
	 * 
	 * word = "ABCCED", -> returns true,
	 * 
	 * word = "SEE", -> returns true,
	 * 
	 * word = "ABCB", -> returns false.
	 */

	private boolean search(char[][] board, String word, int wordLen, int pos, boolean[][] isUse,
			int i, int j) {
		if (pos == wordLen)
			return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;

		if (!isUse[i][j] &&board[i][j] == word.charAt(pos)) {
			isUse[i][j] = true;
			
			if (search(board, word, wordLen, pos + 1, isUse, i , j - 1)) {
				isUse[i][j] = false;
				return true;
			}
			if (search(board, word, wordLen, pos + 1, isUse, i, j + 1)) {
				isUse[i][j] = false;
				return true;
			}
			if (search(board, word, wordLen, pos + 1, isUse, i - 1, j)) {
				isUse[i][j] = false;
				return true;
			}
			if (search(board, word, wordLen, pos + 1, isUse, i+1, j )) {
				isUse[i][j] = false;
				return true;
			}
			
			isUse[i][j] = false;
			return false;
		} else {
			return false;
		}
	}

	public boolean exist(char[][] board, String word) {
		boolean[][] isUse = new boolean[board.length][board[0].length];
		int wordLen = word.length();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (search(board, word, wordLen, 0, isUse, i, j))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(solution.exist(board, "ABCCED"));
		System.out.println(solution.exist(board, "SEE"));
		System.out.println(solution.exist(board, "ABCB"));
//		System.out.println(solution.exist(board, "ABCCED"));

	}
}
