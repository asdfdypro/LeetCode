package asdf.test;

public class Solution {

	/**
	 * (生命游戏) According to the Wikipedia's article:
	 * "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
	 * 
	 * Given a board with m by n cells, each cell has an initial state live (1)
	 * or dead (0). Each cell interacts with its eight neighbors (horizontal,
	 * vertical, diagonal) using the following four rules (taken from the above
	 * Wikipedia article):
	 * 
	 * 
	 * Any live cell with fewer than two live neighbors dies, as if caused by
	 * under-population.
	 * 
	 * Any live cell with two or three live neighbors lives on to the next
	 * generation.
	 * 
	 * Any live cell with more than three live neighbors dies, as if by
	 * over-population..
	 * 
	 * Any dead cell with exactly three live neighbors becomes a live cell, as
	 * if by reproduction.
	 * 
	 * 
	 * Write a function to compute the next state (after one update) of the
	 * board given its current state.
	 * 
	 * Follow up:
	 * 
	 * Could you solve it in-place? Remember that the board needs to be updated
	 * at the same time: You cannot update some cells first and then use their
	 * updated values to update other cells. In this question, we represent the
	 * board using a 2D array. In principle, the board is infinite, which would
	 * cause problems when the active area encroaches the border of the array.
	 * How would you address these problems?
	 */
	
	//用位表示
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int lives = countLive(board, i, j);

				// 一定存货的
				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
				}
				// 复活的
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] >>= 1; // Get the 2nd state.
			}
		}
	}

	private int countLive(int[][] board, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[x].length - 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

	}
}
