package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (二维路径 )The demons had captured the princess (P) and imprisoned her in the
	 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms
	 * laid out in a 2D grid. Our valiant knight (K) was initially positioned in
	 * the top-left room and must fight his way through the dungeon to rescue
	 * the princess.
	 * 
	 * The knight has an initial health point represented by a positive integer.
	 * If at any point his health point drops to 0 or below, he dies
	 * immediately.
	 * 
	 * Some of the rooms are guarded by demons, so the knight loses health
	 * (negative integers) upon entering these rooms; other rooms are either
	 * empty (0's) or contain magic orbs that increase the knight's health
	 * (positive integers).
	 * 
	 * In order to reach the princess as quickly as possible, the knight decides
	 * to move only rightward or downward in each step.
	 * 
	 * Write a function to determine the knight's minimum initial health so that
	 * he is able to rescue the princess.
	 * 
	 * Notes:
	 * 
	 * The knight's health has no upper bound.
	 * 
	 * Any room can contain threats or power-ups, even the first room the knight
	 * enters and the bottom-right room where the princess is imprisoned.
	 */

	// DP
	// 逆方向循环
	// f[i][j]//到达公主处,最低血量
	// 如果路径需要的血量，小于当前值，需要血量为0
	// 否则取小值

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] f = new int[m][n];

		// 最后一格
		f[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? -dungeon[m - 1][n - 1] : 0;

		int a, b;
		// 最后一列
		for (int i = m - 2; i >= 0; i--) {
			a = f[i + 1][n-1] - dungeon[i][n-1];
			f[i][n-1] = a > 0 ? a : 0;
		}
		// 最后一行
		for (int j = n - 2; j >= 0; j--) {
			b = f[m-1][j + 1] - dungeon[m-1][j];
			f[m-1][j] = b > 0 ? b : 0;
		}

		for (int i = m-2; i >= 0; i--) {
			for (int j = n-2;j >= 0; j--) {
				a = f[i + 1][j] - dungeon[i][j];
				a = a > 0 ? a : 0;
				b = f[i][j + 1] - dungeon[i][j];
				b = b > 0 ? b : 0;
				f[i][j] = a < b ? a : b;
			}
		}

		return f[0][0]+1;//保证最少有1
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 },
				{ 10, 30, -5 } }));
		System.out.println(solution.calculateMinimumHP(new int[][] { { 0 } }));
		System.out.println(solution.calculateMinimumHP(new int[][] { { 1, 2, 3 } }));
		System.out.println(solution.calculateMinimumHP(new int[][] { { -1, -2, -3 } }));
	}
}
