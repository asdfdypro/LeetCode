package asdf.test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

	/**
	 * (拓扑排序) There are a total of n courses you have to take, labeled from 0 to
	 * n - 1.
	 * 
	 * Some courses may have prerequisites, for example to take course 0 you
	 * have to first take course 1, which is expressed as a pair: [0,1]
	 * 
	 * Given the total number of courses and a list of prerequisite pairs, is it
	 * possible for you to finish all courses?
	 * 
	 * For example:
	 * 
	 * 2, [[1,0]]
	 * 
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0. So it is possible.
	 * 
	 * 2, [[1,0],[0,1]]
	 * 
	 * There are a total of 2 courses to take. To take course 1 you should have
	 * finished course 0, and to take course 0 you should also have finished
	 * course 1. So it is impossible.
	 * 
	 * Note: The input prerequisites is a graph represented by a list of edges,
	 * not adjacency matrices. Read more about how a graph is represented.
	 * 
	 */
	// 优先队列30ms
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] map = new int[numCourses];//存储出边个数

		for (int i = 0; i < prerequisites.length; i++) {
			map[prerequisites[i][1]]++;
		}

		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0)
				que.add(i);
		}

		int count = que.size();
		while (!que.isEmpty()) {
			int k = que.remove();
			for (int i = 0; i < prerequisites.length; i++) {
				if (k == prerequisites[i][0]) {
					int l = prerequisites[i][1];
					map[l]--;
					if (map[l] == 0) {
						que.add(l);
						++count;
					}
				}
			}
		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.canFinish(8, new int[][] { { 1, 0 }, { 2, 6 }, { 1, 7 },
				{ 5, 1 }, { 6, 4 }, { 7, 0 }, { 0, 5 }, { 5, 1 }, { 6, 4 } }));

	}
}