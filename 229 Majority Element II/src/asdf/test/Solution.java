package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (出现次数大于1/3的元素)Given an integer array of size n, find all elements that
	 * appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time
	 * and in O(1) space.
	 */
	// 类似169 用两个计数
	public List<Integer> majorityElement(int[] nums) {
		int elem1 = 0;
		int count1 = 0;
		int elem2 = 0;
		int count2 = 0;

		for (int i : nums) {
			// 先处理相等
			if (elem1 == i) {
				count1++;
			} else if (elem2 == i) {
				count2++;
			} else if (count1 == 0) {
				elem1 = i;
				count1 = 1;

			} else if (count2 == 0) {
				elem2 = i;
				count2 = 1;

			} else {
				count1--;
				count2--;
			}
		}
		// 重新计数
		count1 = 0;
		count2 = 0;
		for (int i : nums) {
			if (i == elem1)
				count1++;
			if (i == elem2)
				count2++;
		}

		List<Integer> res = new ArrayList<>();
		if (count1 > nums.length / 3)
			res.add(elem1);
		if (elem2 != elem1 && count2 > nums.length / 3)// 注意相等
			res.add(elem2);
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.majorityElement(new int[] {}));
		System.out.println(solution.majorityElement(new int[] { 1, 1 }));
		System.out.println(solution.majorityElement(new int[] { 8, 8, 7, 7, 7 }));
		System.out.println(solution.majorityElement(new int[] { 0, 0, 0 }));// 0的情况
		System.out.println(solution.majorityElement(new int[] { 1, 2, 2, 3, 2, 1, 1, 3 }));
	}
}
