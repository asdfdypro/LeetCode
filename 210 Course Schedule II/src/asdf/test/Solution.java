package asdf.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	/**
	 * (拓扑排序，返回序列) There are a total of n courses you have to take, labeled from
	 * 0 to n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs,
	 * return the ordering of courses you should take to finish all courses.
	 * 
	 * There may be multiple correct orders, you just need to return one of
	 * them. If it is impossible to finish all courses, return an empty array.
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]]
	 * 
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So the correct course order is [0,1]
	 * 
	 * 4, [[1,0],[2,0],[3,1],[3,2]]
	 * 
	 * There are a total of 4 courses to take. To take course 3 you should have
	 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after
	 * you finished course 0. So one correct course order is [0,1,2,3]. Another
	 * correct ordering is[0,2,1,3].
	 * 
	 */
	//考虑为空
	// 优先队列67ms
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];

		int[] map = new int[numCourses];// 存储出边个数

		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		int count = numCourses;
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) {
				que.add(i);
				res[--count] = i;
			}
		}

		while (!que.isEmpty()) {
			int k = que.remove();
			for (int i = 0; i < prerequisites.length; i++) {
				if (k == prerequisites[i][0]) {
					int l = prerequisites[i][1];
					map[l]--;
					if (map[l] == 0) {
						que.add(l);
						res[--count] = l;
					}
				}
			}
		}
		if (count == 0) {
			return res;
		}
		return new int[0];

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 },
				{ 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(solution.findOrder(2, new int[][] { { 0, 1 }, { 1,0} })));
	}
}