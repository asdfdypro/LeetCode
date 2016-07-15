package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {

	/**
	 * (周围区域) Given a 2D board containing 'X' and 'O', capture all regions
	 * surrounded by 'X'.
	 * 
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region.
	 * 
	 * For example,
	 * 
	 * X X X X
	 * 
	 * X O O X
	 * 
	 * X X O X
	 * 
	 * X O X X
	 * 
	 * After running your function, the board should be:
	 * 
	 * X X X X
	 * 
	 * X X X X
	 * 
	 * X X X X
	 * 
	 * X O X X
	 * 
	 */

	// 从边上的O点，向内广度搜索（深搜栈溢出），标记可达点
	// 22 ms
	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		if (board[0].length == 0)
			return;

		int[][] visited = new int[board.length][board[0].length];// 组号
		Queue<P> queue = new LinkedList<>();
		P p,pp;
		// 搜索四周
		for (int i = 0; i < board.length; i++) {
			p = new P(i, 0);
			if (enable(board, visited, p))
				queue.offer(p);
			p = new P(i, board[i].length - 1);
			if (enable(board, visited, p))
				queue.offer(p);
		}
		for (int j = 1; j < board[0].length - 1; j++) {
			p = new P(0, j);
			if (enable(board, visited, p))
				queue.offer(p);
			p = new P(board.length - 1, j);
			if (enable(board, visited, p))
				queue.offer(p);
		}
		while (!queue.isEmpty()) {
			p = queue.poll();
			visited[p.i][p.j] = 1;
			pp = new P(p.i - 1, p.j);
			if (enable(board, visited, pp))
				queue.offer(pp);
			pp = new P(p.i + 1, p.j);
			if (enable(board, visited, pp))
				queue.offer(pp);
			pp = new P(p.i, p.j - 1);
			if (enable(board, visited, pp))
				queue.offer(pp);
			pp = new P(p.i, p.j + 1);
			if (enable(board, visited, pp))
				queue.offer(pp);
		}

		
		// 保留访问过的，其他表为X
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && visited[i][j] == 0)
					board[i][j] = 'X';
			}
		}

	}

	private boolean enable(char[][] board, int[][] visited, P p) {
		if (p.i < 0 || p.i >= board.length)
			return false;
		if (p.j < 0 || p.j >= board[p.i].length)
			return false;
		if (board[p.i][p.j] == 'X')
			return false;
		if (visited[p.i][p.j] > 0)
			return false;
		return true;
	}

	class P {
		int i;
		int j;

		public P(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, {
		// 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };

//		char[][] board = { { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X' },
//				{ 'X', 'X', 'X', 'X' } };

		// char[][] board = {
		// { 'X', 'X', 'X', 'X' },
		// { 'X', 'O', 'O', 'O' }, {
		// 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };
		
		char[][] board = { {'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		
		print(board);
		solution.solve(board);
		print(board);

	}

	private static void print(char[][] b) {
		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.println(Arrays.toString(b[i]));
		}
	}

	private static void print(int[][] b) {
		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.println(Arrays.toString(b[i]));
		}
	}
}
