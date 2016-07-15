package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (寻找缺失数) Given an array containing n distinct numbers taken from 0, 1, 2,
	 * ..., n, find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * Note: Your algorithm should run in linear runtime complexity. Could you
	 * implement it using only constant extra space complexity?
	 */
	//先排序
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (n != nums[i])
				break;
			else
				n++;
		}
		return n;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.missingNumber(new int[] { 0 }));// 完整序列
		System.out.println(solution.missingNumber(new int[] { 0, 1, 3 }));// 缺失序列
		System.out.println(solution.missingNumber(new int[] { 1,0 }));// 乱序
	}
}
