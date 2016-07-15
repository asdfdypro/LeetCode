package asdf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	/**
	 * (一条线上，最多的点数 ) Given n points on a 2D plane, find the maximum number of
	 * points that lie on the same straight line.
	 */
	// 注意重复的点，重复计算
	// 不一定是正（横、竖、斜）的线
	//只有一个点或两个点的情况
	//注意浮点误差

	// 两层循环搜索，注意：一旦一条线上，某个点已经搜索过了，所有的点都搜索过了，注意重复点的重复计算
	public int maxPoints(Point[] points) {
		Map<Double, Map<Point, Integer>> pMap = new HashMap<>();

		int max = 0, base;
		double k;
		Integer n;
		Map<Double, Integer> tMap;
		Map<Point, Integer> bMap;
		boolean isRepeat;

		// 排序
		Arrays.sort(points, pointComparator);
		
//		for (Point point : points) {
//			System.out.print("["+point.x+","+point.y+"],");
//		}
//		System.out.println();
		

		for (int i = 0; i < points.length; i++) {
			tMap = new HashMap<Double, Integer>();// 当前点的斜率集合
			base = 1;
			// 相同点
			while (i + 1 < points.length && points[i].x == points[i + 1].x
					&& points[i].y == points[i + 1].y) {
				i++;
				base++;
			}

			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x)
					k = Double.MAX_VALUE;
				else
					k = (points[i].y - points[j].y) / (points[i].x - points[j].x-0.0);
				n = tMap.get(k);
				if (n == null)
					n = base;
				tMap.put(k, ++n);
				if(k==3)
					System.out.println(n+"@"+points[i]+"=="+points[j]);
			}
			// 合并结果
			for (double key : tMap.keySet()) {
				bMap = pMap.get(key);
				isRepeat = false;
				if (bMap == null) {// 创建新结果
					bMap = new HashMap<Point, Integer>();
					pMap.put(key, bMap);
				} else {// 检查是否重合
					for (Point point : bMap.keySet()) {
						if (points[i].x == point.x)
							k = Double.MAX_VALUE;
						else
							k = (points[i].y - point.y) / (points[i].x - point.x-0.0);
						if (k == key) {
							// 重复
							isRepeat = true;
							break;
						}
					}
				}
				// 插入新结果
				if (!isRepeat) {
					n = tMap.get(key);
				
					bMap.put(points[i], n);
					if (n > max)
						max = n;
				}
			}
		}

//		 for (double d : pMap.keySet()) {
//		 System.out.println(d);
//		 }
		if (max == 0)//只有一个点
			return points.length;
		else
			return max;
	}

	private static Comparator<Point> pointComparator = new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x;
		}
	};

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
//		int[][] nums = { { 0, 0 },{ 0, 0 } };
		int[][] nums = 	{{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691},{-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
		Point[] points = new Point[nums.length];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(nums[i][0], nums[i][1]);
		}
		System.out.println(solution.maxPoints(points));
	}
}
