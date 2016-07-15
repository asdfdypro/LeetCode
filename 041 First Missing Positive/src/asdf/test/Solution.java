package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (查询第一个不存在的整数) Given an unsorted integer array, find the first missing
	 * positive integer.
	 * 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 * ,2,7,6,1,5 and target 8, A solution set is: [1, 7] [1, 2, 5] [2, 6] [1,
	 * 1, 6]
	 */

	public int firstMissingPositive(int[] nums) {

		boolean[] show = new boolean[nums.length];// 是否出现
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length)
				show[nums[i] - 1] = true;
		}
		i = 0;
		for (; i < nums.length; i++) {
			if (!show[i])
				break;
		}

		i++;
		return i;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = {1,2};
		System.out.println(solution.firstMissingPositive(candidates));

	}

}
