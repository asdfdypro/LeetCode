package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (计算交际) Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Note:
	 * 
	 * Each element in the result must be unique. The result can be in any
	 * order.
	 */

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> res = new HashSet<Integer>();
		int count;
		for (int i : nums1) {
			count = map.containsKey(i) ? map.get(i) : 0;
			map.put(i, count + 1);
		}
		for (int i : nums2) {
			count = map.containsKey(i) ? map.get(i) : 0;
			if (count > 0) {
				res.add(i);
				map.put(i, count - 1);
			}
		}
		int[] r = new int[res.size()];int i=0;
		for (int n : res) {
			r[i++]=n;
		}
		return r;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.intersect(new int[] { 1, 2, 2, 1 }, new int[] {
				2, 2 })));
	}
}
