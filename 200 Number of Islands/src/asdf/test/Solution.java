package asdf.test;


public class Solution {

	/**
	 * (数据孤岛)Given a 2d grid map of '1's (land) and '0's (water), count the
	 * number of islands. An island is surrounded by water and is formed by
	 * connecting adjacent lands horizontally or vertically. You may assume all
	 * four edges of the grid are all surrounded by water.
	 */
//存在错误特例
	public int numIslands(char[][] grid) {
		int res = 0;
		if (grid.length > 0 && grid[0].length > 0) {
			res = grid[0][0] == '1' ? 1 : 0;
			for (int i = 1; i < grid.length; i++) {
				if (grid[i - 1][0] == '0'&& grid[i][0 ] == '1')
					res++;
			}
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[0][j - 1] == '0'&& grid[0][j ] == '1')
					res++;
			}
			for (int i =1; i < grid.length; i++) {
				for (int j = 1; j < grid[0].length; j++) {
					if (grid[i - 1][j] == '0' && grid[i][j - 1] == '0'&& grid[i][j ] == '1')
						res++;
					System.out.println(String.format("%d=%d,%d", res,i,j));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

//		System.out.println(solution.numIslands(new char[][] { { '1', '0', '0', '0' },
//				{ '1', '0', '1', '0' }, { '1', '0', '0', '1' }, { '1', '0', '1', '0' } }));
		System.out.println(solution.numIslands(new char[][] { { '1', '1', '1' },
				{ '0','1', '0' }, { '1','1', '1' } }));
	}
}