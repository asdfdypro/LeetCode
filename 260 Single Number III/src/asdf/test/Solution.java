package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (只出现一次的两个数字) Given an array of numbers nums, in which exactly two
	 * elements appear only once and all the other elements appear exactly
	 * twice. Find the two elements that appear only once.
	 * 
	 * For example:
	 * 
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * 
	 * Note:
	 * 
	 * The order of the result is not important. So in the above example, [5, 3]
	 * is also correct. Your algorithm should run in linear runtime complexity.
	 * Could you implement it using only constant space complexity?
	 */
	public int[] singleNumber(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;// 从低位开始，只有第一位为1的二进制数

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will
		for (int num : nums) {
			if ((num & diff) == 0) 
			{
				rets[0] ^= num;//分别异或
			} else 
			{
				rets[1] ^= num;//分别异或
			}
		}
		return rets;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 })));
	}
}
