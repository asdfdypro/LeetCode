package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution2 {

	/**
	 * (最大矩形)Given n non-negative integers representing the histogram's bar
	 * height where the width of each bar is 1, find the area of largest
	 * rectangle in the histogram.
	 */

	// 对于一个递增的高度（2,3,4）可使用2*3,3*2,4*1计算
	// 对于一块大于两遍的 孤岛 不会影响周围的元素
	// 使用一个栈，然后遍历时如果height[i] 大于stack.top()，进栈。反之，出栈直到栈顶元素小于height[i]。
	// 出栈元素即为一个递增的孤岛（大于两遍的元素）
	// 该孤岛不会影响其他元素的计算，一算此孤岛的最大面积即可

	// 改进实现方法
	public int largestRectangleArea(int[] height) {
		int maxRectangle = 0;
		Stack<Integer> workStack = new Stack<Integer>();
		int tmp;
		for (int i = 0; i < height.length; i++) {
			if (workStack.isEmpty() || height[i] > height[workStack.peek()])
				workStack.push(i);
			else {
				tmp = workStack.pop();
				tmp = height[tmp] * (workStack.empty() ? i : i - workStack.peek() - 1);

				if (tmp > maxRectangle)
					maxRectangle = tmp;
				i--;
			}
		}
		while (!workStack.isEmpty() && height[workStack.peek()] > 0) {
			tmp = workStack.pop();
			tmp = height[tmp]
					* (workStack.empty() ? height.length : height.length - workStack.peek() - 1);

			if (tmp > maxRectangle)
				maxRectangle = tmp;
		}

		return maxRectangle;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] height = { 2,3 };

		System.out.println(solution.largestRectangleArea(height));

	}
}
