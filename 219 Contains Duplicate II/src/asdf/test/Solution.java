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
	 * (判断是否有重复,且距离小于k)Given an array of integers and an integer k, find out
	 * whether there are two distinct indices i and j in the array such that
	 * nums[i] = nums[j] and the difference between i and j is at most k.
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		Map<Integer,Integer> map = new HashMap<>();
		Integer last;
		for (int i = 0; i < nums.length; i++) {			
			last=map.get(nums[i]);			
			if (last!=null&&i-last<=k) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3 ,3}, 1));
	}
}
