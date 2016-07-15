package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (元素乘积) Given an array of n integers where n > 1, nums, return an array
	 * output such that output[i] is equal to the product of all the elements of
	 * nums except nums[i].
	 * 
	 * Solve it without division and in O(n).
	 * 
	 * For example, given [1,2,3,4], return [24,12,8,6].
	 * 
	 * Follow up: Could you solve it with constant space complexity? (Note: The
	 * output array does not count as extra space for the purpose of space
	 * complexity analysis.)
	 */
	// 看成一个二维矩阵
	// 分别求两遍的乘积
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] output = new int[nums.length];

		left[0] = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			left[i + 1] = left[i] * nums[i];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			right[i - 1] = right[i] * nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			output[i] = left[i] * right[i];
		}

		return output;
	}

	// 合并空间
	public int[] productExceptSelf2(int[] nums) {
		int[] output = new int[nums.length];
		int left = 1;

		// 先计算右面
		output[nums.length - 1] = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			output[i - 1] = output[i] * nums[i];
		}

		for (int i = 1; i < nums.length; i++) {
			left = left * nums[i - 1];// 左面
			output[i] = left * output[i];// 左面*右面
		}

		return output;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(Arrays.toString(solution.productExceptSelf2(new int[] { 1, 2, 3, 4 })));

	}
}
