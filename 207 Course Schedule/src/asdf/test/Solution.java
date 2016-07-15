package asdf.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

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
	// hash存储  	70 ms 
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1) {
			return true;
		}
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

		int count = 0, lastCount = -1;
		while (count < numCourses) {
			count = 0;
			for (i = 0; i < setIn.length; i++) {
				if (setIn[i] == null || setIn[i].size() == 0) {
					count++;
					if (setOut[i] != null) {
						for (Integer k : setOut[i]) {
							setIn[k].remove(i);
						}
						setOut[i] = null;
					}
				}
			}
			if (count == lastCount) {
				return false;
			} else {
				lastCount = count;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canFinish(8, new int[][] { { 1, 0 }, { 2, 6 }, { 1, 7 },
				{ 5, 1 }, { 6, 4 }, { 7, 0 }, { 0, 5 }, { 5, 1 }, { 6, 4 } }));

	}
}