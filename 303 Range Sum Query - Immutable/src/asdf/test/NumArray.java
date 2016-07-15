package asdf.test;

import java.util.Arrays;

public class NumArray {

	/**
	 * (数组求和) Given an integer array nums, find the sum of the elements between
	 * indices i and j (i ≤ j), inclusive.
	 * 
	 * Example:
	 * 
	 * Given nums = [-2, 0, 3, -5, 2, -1]
	 * 
	 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
	 * 
	 * Note:
	 * 
	 * You may assume that the array does not change. There are many calls to
	 * sumRange function.
	 */

	private int[] sum;

	public NumArray(int[] nums) {
		int sum = 0;
		this.sum = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			this.sum[i] = sum;
			sum += nums[i];
		}
		this.sum[nums.length]=sum;
//		System.out.println(Arrays.toString(this.sum));
	}

	public int sumRange(int i, int j) {
		return this.sum[j+1] - this.sum[i];
	}

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2,5));
		System.out.println(numArray.sumRange(0, 5));
	}
}
