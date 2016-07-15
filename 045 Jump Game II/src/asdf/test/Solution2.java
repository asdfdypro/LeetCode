package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {

	/**
	 * (最小跳过步数) Given an array of non-negative integers, you are initially
	 * positioned at the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 */

	// dp 剪枝
	public int jump(int[] nums) {
		int[] f = new int[nums.length];// 所需步数

		int pos;
		int maxPos;
		int des = 0;// 当前最远距离，剪枝
		for (int i = 0; i < nums.length; i++) {
			pos = i + 1;
			maxPos = nums[i] + i;
			// 加速
			if (des >= pos)
				pos = des + 1;
			if (maxPos > des)
				des = maxPos;

			for (; pos < nums.length && pos <= maxPos; pos++) {
				f[pos] = f[i] + 1;
			}

			// 加速
			if (pos == nums.length)
				break;
		}
		return f[nums.length - 1];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] matrix =
		// { 2, 1, 1, 1, 4 };
		// { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		 {3,2,1,0,4};
//		{ 5, 4, 3, 2, 1, 1, 0 };
		int es = solution.jump(matrix);

		System.out.println(es);

	}
}
