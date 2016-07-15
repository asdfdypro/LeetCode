package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (判断是否有差小于t,且距离小于k)Given an array of integers, find out whether there are
	 * two distinct indices i and j in the array such that the difference
	 * between nums[i] and nums[j] is at most t and the difference between i and
	 * j is at most k.
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int[] sortNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortNums);
		Map<Integer, Integer> numToPosMap = new HashMap<>();
		int j, max;
		Integer last;
		for (int i = 0; i < nums.length; i++) {
			j = Arrays.binarySearch(sortNums, nums[i] - t);
			if (j < 0)
				j = -1 - j;
			max = nums[i] + t;
			if (nums[i] > 0 && max < 0)// 注意溢出
				max = Integer.MAX_VALUE;
			for (; j < sortNums.length && sortNums[j] <= max; j++) {
				last = numToPosMap.get(sortNums[j]);
				if (last != null && i - last <= k) {
					return true;
				}
			}
			numToPosMap.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 7, 4, 9, }, 1, 1));

		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 0, 2147483647 }, 1,
				2147483647));// 注意溢出

		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 2, 0, -2, 2 }, 2, 1));// 注意负数
	}
}
