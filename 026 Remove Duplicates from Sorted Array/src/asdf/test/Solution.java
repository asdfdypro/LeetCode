package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (删除有序数组重复元素，返回新数组长度) Given a sorted array, remove the duplicates in place
	 * such that each element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	 * the new length.
	 */

	public int removeDuplicates(int[] nums) {

		if (nums.length == 0)
			return 0;

		int m = nums[0];
		int p = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != m) {
				nums[p++] = m;
				m = nums[i];
			}
		}
		nums[p++] = m;

		return p;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] n = { 1,2,2,4 };
		System.out.println(solution.removeDuplicates(n));
		System.out.println(Arrays.toString(n));

	}

}
