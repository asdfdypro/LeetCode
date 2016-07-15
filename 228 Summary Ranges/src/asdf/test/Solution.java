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
	 * (压缩数组) Given a sorted integer array without duplicates, return the
	 * summary of its ranges.
	 * 
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums.length > 0) {
			int last = nums[0], from = last;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] - last != 1) {
					if (last != from)
						res.add(String.format("%d->%d", from, last));
					else
						res.add(String.format("%d", from));
					from = nums[i];
				}
				last = nums[i];
			}
			if (last != from)
				res.add(String.format("%d->%d", from, last));
			else
				res.add(String.format("%d", from));

		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.summaryRanges(new int[] {  }));
		System.out.println(solution.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));

		System.out.println(solution.summaryRanges(new int[] { 0, 2, 4, 5, 7,8 }));
	}
}
