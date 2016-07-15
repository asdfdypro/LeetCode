package asdf.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (一条线上，最多的点数 ) Given n points on a 2D plane, find the maximum number of
	 * points that lie on the same straight line.
	 */
	// 注意重复的点，重复计算
	// 不一定是正（横、竖、斜）的线
	public int maxPoints(Point[] points) {
		Map<Integer, Set<Integer>> pMap = new HashMap<>();
		Map<Integer, Integer> row = new HashMap<>();
		Map<Integer, Integer> col = new HashMap<>();
		Map<Integer, Integer> rc = new HashMap<>();
		Map<Integer, Integer> cr = new HashMap<>();
		int max = 0;
		Set<Integer> pSet;

		for (Point point : points) {
			pSet = pMap.get(point.x);
			if (pSet != null && pSet.contains(point.y))
				continue;

			max = make(row, point.x, max);
			max = make(col, point.y, max);
			max = make(rc, point.x + point.y, max);
			max = make(cr, point.x - point.y, max);

			if (pSet == null) {
				pSet = new HashSet<>();
				pMap.put(point.x, pSet);
			}
			pSet.add(point.y);
		}

		return max;
	}

	private int make(Map<Integer, Integer> map, int key, int max) {
		Integer p;
		p = map.get(key);
		if (p == null)
			p = 0;
		map.put(key, ++p);
		if (p > max)
			max = p;
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] nums = { { 0, 0 }, { 0, 0 } };
		Point[] points = new Point[nums.length];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(nums[i][0], nums[i][1]);
		}
		System.out.println(solution.maxPoints(points));
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
