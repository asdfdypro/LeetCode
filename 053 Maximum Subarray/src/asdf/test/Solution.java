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
	 * (最大子串和)Find the contiguous subarray within an array (containing at least
	 * one number) which has the largest sum.
	 */

	// 动规
	public int maxSubArray(int[] nums) {
		int f = 0;// 以i结尾的最大和
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (f > 0)
				f += nums[i];
			else
				f = nums[i];
			
			if (f > max)
				max = f;
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] matrix =

//		{ -2, 1, -3, 4, -1, 2, 1, -5, 4 }
		{ 2,-1,3 }
		;

		int es = solution.maxSubArray(matrix);

		System.out.println(es);

	}
}
