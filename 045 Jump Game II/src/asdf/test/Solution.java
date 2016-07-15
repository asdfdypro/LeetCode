package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

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

	//dp超时
	public int jump(int[] nums) {
		int[] f = new int[nums.length];// 所需步数

		int pos;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				pos = i + j;
				if (pos < nums.length) {
					if (f[pos] == 0 || f[pos] - f[i] > 1)
						f[pos] = f[i] + 1;
				}
			}
		}
		return f[nums.length - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] matrix = { 2, 2, 0, 0, 4 };

		int es = solution.jump(matrix);

		System.out.println(es);

	}
}
