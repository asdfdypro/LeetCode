package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	/**
	 * (装最多水的桶)Given n non-negative integers a1, a2, ..., an, where each
	 * represents a point at coordinate (i, ai). n vertical lines are drawn such
	 * that the two endpoints of line i is at (i, ai) and (i, 0). Find two
	 * lines, which together with x-axis forms a container, such that the
	 * container contains the most water.
	 * 
	 * Note: You may not slant the container.
	 */
	// 类似于快排，两遍两个指针想中间聚拢，保证长度最大，
	// 低的先向中间聚拢，新考虑的点与低的组成的面积已经计算过了

	public int maxArea(int[] height) {
		int max = 0, l = 0, r = height.length - 1, area;
		while (l < r) {
			area = (height[l] > height[r] ? height[r] : height[l]) * (r - l);
			if (area > max)
				max = area;

			if (height[l] > height[r])// 关键
				r--;
			else
				l++;
		}

		return max;
	}

	public static void main(String[] args) {

		Solution2 solution = new Solution2();

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