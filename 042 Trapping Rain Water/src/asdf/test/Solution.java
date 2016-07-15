package asdf.test;

public class Solution {

	/**
	 * (计算容器盛水) Given n non-negative integers representing an elevation map
	 * where the width of each bar is 1, compute how much water it is able to
	 * trap after raining.
	 */

	// 同Container With Most Water 两点解决
	// 两个指针指向两头，矮的先移动，以矮的高度组成水平线。
	// 如果低，一定存水，如果高，更新水平线
	public int trap(int[] height) {
		if (height.length < 3)
			return 0;

		int sum = 0;
		int i = 0, j = height.length - 1, k;
		int hr = height[i] > height[j] ? height[j] : height[i];
		while (i < j) {
			if (height[i] > height[j]) {
				j--;
				k = j;
			} else {
				i++;
				k = i;
			}
			
			if (height[k] < hr) {
				sum += hr - height[k];
			} else if (height[k] > hr) {
				hr = height[i] > height[j] ? height[j] : height[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = { 2,0,3,0,4 };
		System.out.println(solution.trap(candidates));

	}

}
