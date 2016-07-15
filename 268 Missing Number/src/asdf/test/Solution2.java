package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (寻找缺失数) Given an array containing n distinct numbers taken from 0, 1, 2,
	 * ..., n, find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * Note: Your algorithm should run in linear runtime complexity. Could you
	 * implement it using only constant extra space complexity?
	 */

	public int missingNumber(int[] nums) {
		int n =0,xor=0;
		for (int i=0; i < nums.length; i++) {
			xor^=nums[i];
			n^=i;
		}
		n=n^xor^ nums.length;		
		return n;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.missingNumber(new int[] { }));
		System.out.println(solution.missingNumber(new int[] { 0 }));// 完整序列
		System.out.println(solution.missingNumber(new int[] { 0, 1, 3 }));// 缺失序列
		System.out.println(solution.missingNumber(new int[] { 1, 0 }));// 乱序
	}
}
