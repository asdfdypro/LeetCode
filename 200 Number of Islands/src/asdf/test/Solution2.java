package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	/**
	 * (数据孤岛)Given a 2d grid map of '1's (land) and '0's (water), count the
	 * number of islands. An island is surrounded by water and is formed by
	 * connecting adjacent lands horizontally or vertically. You may assume all
	 * four edges of the grid are all surrounded by water.
	 */
	// 并查集
	public int numIslands(char[][] grid) {

		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int[][] union = new int[grid.length][grid[0].length];

		List<Integer> count = new ArrayList<Integer>();
		int t, s;

		if (grid[0][0] == '1') {
			union[0][0] = count.size();
			count.add(-1);
		}
		for (int i = 1; i < grid.length; i++) {
			if (grid[i][0] == '1') {
				if (grid[i - 1][0] == '0') {
					union[i][0] = count.size();
					count.add(-1);
				} else
					union[i][0] = union[i - 1][0];
			}
		}
		for (int j = 1; j < grid[0].length; j++) {
			if (grid[0][j] == '1') {
				if (grid[0][j - 1] == '0') {
					union[0][j] = count.size();
					count.add(-1);
				} else
					union[0][j] = union[0][j - 1];
			}
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					if (grid[i - 1][j] == '0' && grid[i][j - 1] == '0') {
						union[i][j] = count.size();
						count.add(-1);
					} else if (grid[i - 1][j] == '0') {
						t = union[i][j - 1];
						while (count.get(t) != -1)
							t = count.get(t);
						union[i][j] = t;
					} else if (grid[i][j - 1] == '0') {
						t = union[i - 1][j];
						while (count.get(t) != -1)
							t = count.get(t);
						union[i][j] = t;
					}

					else {

						t = union[i - 1][j];
						while (count.get(t) != -1)
							t = count.get(t);
						s = union[i][j - 1];
						while (count.get(s) != -1)
							s = count.get(s);

						if (s == t)
							union[i][j] = s;
						else {
							union[i][j] = count.size();
							count.add(-1);
							count.set(t, union[i][j]);
							count.set(s, union[i][j]);
						}
					}
				}
			}
		}

		int res = 0;
		for (Integer integer : count) {
			if (integer == -1) {
				res++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// System.out.println(solution.numIslands(new char[][] { { '1', '0',
		// '0', '0' },
		// { '1', '0', '1', '0' }, { '1', '0', '0', '1' }, { '1', '0', '1', '0'
		// } }));
		// System.out.println(solution.numIslands(new char[][] { { '1', '1', '1'
		// }, { '0', '1', '0' },
		// { '1', '1', '1' } }));
		// System.out.println(solution.numIslands(new char[][] { { '0', '1', '0'
		// }, { '1', '0', '1' },
		// { '0', '1', '0' } }));
		// System.out.println(solution.numIslands(new char[][] { { '1', '1', '1'
		// }, { '1', '0', '1' },
		// { '1', '1', '1' } }));
		System.out.println(solution.numIslands(createCharArrays(new String[] { "1111111",
				"0000001", "1111101", "1000101", "1010101", "1011101", "1111111" })));
	}

	private static char[][] createCharArrays(String[] strings) {
		char[][] res = new char[strings.length][strings[0].length()];
		for (int i = 0; i < strings.length; i++) {
			res[i] = strings[i].toCharArray();
		}
		return res;
	}
}