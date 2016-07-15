package asdf.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

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
	// 考虑为空
	// 优先队列21ms
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];

		Set<Integer>[] setOut = new Set[numCourses];
		Set<Integer>[] setIn = new Set[numCourses];

		int i, j;
		for (int k = 0; k < prerequisites.length; k++) {
			i = prerequisites[k][0];
			j = prerequisites[k][1];
			if (setIn[i] == null) {
				setIn[i] = new HashSet<Integer>();
			}
			setIn[i].add(j);
			if (setOut[j] == null) {
				setOut[j] = new HashSet<Integer>();
			}
			setOut[j].add(i);
		}

		Queue<Integer> que = new LinkedList<Integer>();
		int count = 0;
		for (i = 0; i < setIn.length; i++) {
			if (setIn[i] == null || setIn[i].size() == 0) {
				que.add(i);
				res[count++] = i;
			}
		}

		while (!que.isEmpty()) {
			i = que.poll();
			if (setOut[i] != null) {
				for (Integer k : setOut[i]) {
					setIn[k].remove(i);
					if (setIn[k].size() == 0) {
						que.add(k);
						res[count++] = k;
					}
				}
				setOut[i] = null;
			}

		}
		if (count == numCourses) {
			return res;
		}
		return new int[0];

	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(Arrays.toString(solution.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 },
				{ 3, 1 }, { 3, 2 } })));
		System.out.println(Arrays.toString(solution
				.findOrder(2, new int[][] { { 0, 1 }, { 1, 0 } })));
	}
}