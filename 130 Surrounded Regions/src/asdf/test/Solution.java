package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

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

	// 先将O做并查集，存在边的并查集保留，其他的不保留
	//43 ms
	public void solve(char[][] board) {
		if (board.length == 0)
			return;
		if (board[0].length == 0)
			return;

		// //产生O的并查集
		int[][] group = new int[board.length][board[0].length];// 组号
		List<Integer> relate = new ArrayList<>();// 关系，边上做根的标记-2，其他标记-1

		if (board[0][0] == 'X')
			group[0][0] = -1;
		else
			relate.add(-2);
		// 首行
		for (int i = 1; i < board[0].length; i++) {
			if (board[0][i] == 'X')
				group[0][i] = -1;
			else if (group[0][i - 1] != -1)
				group[0][i] = group[0][i - 1];
			else {
				group[0][i] = relate.size();
				relate.add(-2);
			}
		}
		// 首列
		for (int i = 1; i < board.length; i++) {
			if (board[i][0] == 'X')
				group[i][0] = -1;
			else if (group[i - 1][0] != -1)
				group[i][0] = group[i - 1][0];
			else {
				group[i][0] = relate.size();
				relate.add(-2);
			}
		}
		// 中间元素
		int l, t;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 'X')
					group[i][j] = -1;
				else {

					if (group[i][j - 1] != -1 && group[i - 1][j] != -1) {// 左面、上面都是O
						if (group[i][j - 1] == group[i - 1][j])
							group[i][j] = getRoot(relate, group[i][j - 1]);
						else {// 合并
							group[i][j] = relate.size();
							l = getRoot(relate, group[i][j - 1]);
							t = getRoot(relate, group[i - 1][j]);
							relate.add(relate.get(l) & relate.get(t));// 等于小的
							relate.set(l, group[i][j]);
							relate.set(t, group[i][j]);
						}
					} else if (group[i][j - 1] != -1)// 左面为O
						group[i][j] = getRoot(relate, group[i][j - 1]);
					else if (group[i - 1][j] != -1)// 上面为O
						group[i][j] = getRoot(relate, group[i - 1][j]);
					else {// 创建新类
						group[i][j] = relate.size();
						relate.add(-1);
					}

					// 检查是否是边上的点
					if (i == board.length - 1 || j == board[i].length - 1) {
						relate.set(group[i][j], -2);
					}
				}
			}
		}

		// 保留边上的并查集，其他标记X
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (group[i][j] >= 0) {
					if (relate.get(getRoot(relate, group[i][j])) == -1)
						board[i][j] = 'X';
				}
			}
		}

	}

	private static int getRoot(List<Integer> relate, int g) {
		while (relate.get(g) > 0)
			g = relate.get(g);
		return g;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

//		 char[][] board = {
//		 { 'X', 'X', 'X', 'X' },
//		 { 'X', 'O', 'O', 'X' },
//		 { 'X', 'X', 'O', 'X' },
//		 { 'X', 'O', 'X', 'X' } };

//		char[][] board = { 
//				{ 'X', 'O', 'O', 'X' }, 
//				{ 'X', 'X', 'O', 'X' }, 
//				{ 'X', 'O', 'O', 'X' },
//				{ 'X', 'X', 'X', 'X' } };

		 char[][] board = {
				 { 'X', 'X', 'X', 'X' },
				 { 'X', 'O', 'O', 'O' },
				 { 'X', 'X', 'O', 'X' },
				 { 'X', 'O', 'X', 'X' } };

		 
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
