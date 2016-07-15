package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * (装最多水的桶)Given n non-negative integers a1, a2, ..., an, where each
	 * represents a point at coordinate (i, ai). n vertical lines are drawn such
	 * that the two endpoints of line i is at (i, ai) and (i, 0). Find two
	 * lines, which together with x-axis forms a container, such that the
	 * container contains the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	// map记录每个高度最前面一个位置，遍历height与map中每个计算高度 超时
	// map记录每个高度最前面一个位置，遍历height，再遍历每个高度的map，计算面积超时
	// 记录当前最大面积点低边长和高度，从而剪枝

	public int maxArea(int[] height) {
        int max = 0, nowArea, pre, pos, heigh;
		Map<Integer, Integer> posMap = new HashMap<>();
		for (pos = 0; pos < height.length; pos++) {
			for (int j : posMap.keySet()) {
				pre = posMap.get(j);
				heigh=j<height[pos]?j:height[pos];
				nowArea = (pos - pre) * heigh;
				if (nowArea > max) {
					max = nowArea;
				}
			}
			if (posMap.get(height[pos]) == null)
				posMap.put(height[pos], pos);
		}
		return max;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		int[] a = { 1, 1 };
		int[] b = {};
		int[] c = { 1, 2, 1 };
		int[] d = { 1, 2, 2, 1 };

		System.out.println(solution.maxArea(a));
		System.out.println(solution.maxArea(b));
		System.out.println(solution.maxArea(c));
		System.out.println(solution.maxArea(d));

	}
}