package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (判断是否有重复)Given an array of integers, find if the array contains any
	 * duplicates. Your function should return true if any value appears at
	 * least twice in the array, and it should return false if every element is
	 * distinct.
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : nums) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.containsDuplicate(new int[] {1,2,3,}));
	}
}
