package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	/**
	 * (城市轮廓)A city's skyline is the outer contour of the silhouette formed by
	 * all the buildings in that city when viewed from a distance. Now suppose
	 * you are given the locations and height of all the buildings as shown on a
	 * cityscape photo (Figure A), write a program to output the skyline formed
	 * by these buildings collectively (Figure B).
	 * 
	 * The geometric information of each building is represented by a triplet of
	 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left
	 * and right edge of the ith building, respectively, and Hi is its height.
	 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li
	 * > 0. You may assume all buildings are perfect rectangles grounded on an
	 * absolutely flat surface at height 0.
	 * 
	 * The output is a list of "key points" (red dots in Figure B) in the format
	 * of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
	 * A key point is the left endpoint of a horizontal line segment. Note that
	 * the last key point, where the rightmost building ends, is merely used to
	 * mark the termination of the skyline, and always has zero height. Also,
	 * the ground in between any two adjacent buildings should be considered
	 * part of the skyline contour.
	 */

	// 注意相等的情况
	private static Comparator<int[]> c = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o2[2] - o1[2];
		}
	};

	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> res = new ArrayList<int[]>();
		if (buildings.length == 0) {
			return res;
		}
		if (buildings.length == 1) {
			res.add(new int[] { buildings[0][0], buildings[0][2] });
			res.add(new int[] { buildings[0][1], 0 });
			return res;
		}

		Queue<int[]> heap = new PriorityQueue<>(buildings.length / 2, c);
		int[] maxBuilding = null;
		int[] building, b;
		for (int i = 0; i < buildings.length; i++) {
			if (i + 1 < buildings.length && buildings[i][0] == buildings[i + 1][0]
					&& buildings[i][2] < buildings[i + 1][2]) {// 同起点
				// { 1, 2, 1 }, { 1, 2, 2 }, { 1, 2, 3 }
				if (buildings[i][1] > buildings[i + 1][1])
					heap.add(buildings[i]);
				continue;
			}

			building = buildings[i];
			if (maxBuilding == null) {
				maxBuilding = building;
				res.add(new int[] { building[0], building[2] });
				continue;
			}

			while (maxBuilding[1] < building[0] && heap.peek() != null) {// 不重叠
				b = heap.poll();
				if (b[1] > maxBuilding[1]) {
					res.add(new int[] { maxBuilding[1], b[2] });
					maxBuilding = b;
				}
			}
			if (maxBuilding[1] < building[0]) {// 清空了还够不到
				res.add(new int[] { maxBuilding[1], 0 });
				maxBuilding = building;
				res.add(new int[] { building[0], building[2] });
				continue;
			}

			if (maxBuilding[1] >= building[1]) {// 包含
				if (building[2] > maxBuilding[2]) {
					res.add(new int[] { building[0], building[2] });
					if (maxBuilding[1] > building[1])
						heap.add(maxBuilding);// 入堆再考虑
					maxBuilding = building;
				}
			} else {// 不包含
				if (building[2] > maxBuilding[2]) {
					maxBuilding = building;
					res.add(new int[] { building[0], building[2] });
				} else if (building[2] == maxBuilding[2]) { // { { 0, 2, 3 }, {
															// 2, 5, 3 } };
					maxBuilding = building;
				} else {
					heap.add(building);// 入堆再考虑
				}
			}
		}

		// 处理末尾
		while (heap.peek() != null) {
			b = heap.poll();
			if (b[1] > maxBuilding[1]) {
				res.add(new int[] { maxBuilding[1], b[2] });
				maxBuilding = b;
			}
		}
		res.add(new int[] { maxBuilding[1], 0 });

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		// int[][] buildings = new int[][] { };
		// int[][] buildings = new int[][] { { 2, 9, 10 } };
		// int[][] buildings = new int[][] { { 0, 2, 3 }, { 2, 5, 3 } };
		// int[][] buildings = new int[][] { { 1, 2, 1 }, { 1, 2, 2 }, { 1, 2, 3
		// } };
		// int[][] buildings = new int[][] { { 1, 2, 3 }, { 1, 2, 2 }, { 1, 2,
		// 1}};
		int[][] buildings = new int[][] { { 2, 4, 70 }, { 3, 8, 30 }, { 6, 100, 41 },
				{ 7, 15, 70 }, { 10, 30, 102 }, { 15, 25, 76 }, { 60, 80, 91 }, { 70, 90, 72 },
				{ 85, 120, 59 } };

		List<int[]> res = solution.getSkyline(buildings);

		for (int[] list : res) {
			System.out.println(Arrays.toString(list));
		}
	}
}
