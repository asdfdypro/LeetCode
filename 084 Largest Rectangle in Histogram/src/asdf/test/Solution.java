package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

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
	public int largestRectangleArea(int[] height) {
		int maxRectangle = 0, t;

		Stack<Integer> workStack = new Stack<Integer>();
		List<Integer> workList;
		for (int i = 0; i < height.length; i++) {
			if (workStack.isEmpty())
				workStack.push(i);// 首元素进栈
			else {
				if (height[workStack.peek()] <= height[i]) {
					workStack.push(i);// 大于元素进栈
				} else {
					workList = new ArrayList<Integer>();
					while (!workStack.isEmpty()&&height[workStack.peek()] > height[i])
						workList.add(workStack.pop());
					t = workArea(height, workList);
					if (t > maxRectangle)
						maxRectangle = t;
					
					//构造伪首元素
					t=workList.get(workList.size()-1);
					height[t]=height[i];
					workStack.push(t);
					
					workStack.push(i);// 元素进栈
				}
			}
		}
		//结尾
		workList = new ArrayList<Integer>();
		while (!workStack.isEmpty())
			workList.add(workStack.pop());
		t = workArea(height, workList);
		if (t > maxRectangle)
			maxRectangle = t;

		return maxRectangle;
	}

	private int workArea(int[] height, List<Integer> workList) {
		int size = workList.size();
		if (size < 1)
			return 0;
		int max = 0;
		int begin=workList.get(0);
		int n = begin;
		int m;
		for (int i = 1; i < size; i++) {
			m = workList.get(i);
			if (height[m] != height[n]) {
				n = height[n] * (begin-n+1);
				if (n > max)
					max = n;
			}
			n = m;
		}
		// 结尾
		n = height[n] * (begin-workList.get(size-1)+1);
		if (n > max)
			max = n;

		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] height = {2,1,5,6,2,3 };

		System.out.println(solution.largestRectangleArea(height));

	}
}
