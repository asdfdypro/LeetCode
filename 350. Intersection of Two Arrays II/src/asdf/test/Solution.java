package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (计算交际) Given two arrays, write a function to compute their intersection.
	 * 
	 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 * 
	 * Note:
	 * 
	 * Each element in the result should appear as many times as it shows in
	 * both arrays. The result can be in any order.
	 * 
	 * Follow up:
	 * 
	 * What if the given array is already sorted? How would you optimize your
	 * algorithm? What if nums1's size is small compared to nums2's size? Which
	 * algorithm is better? What if elements of nums2 are stored on disk, and
	 * the memory is limited such that you cannot load all elements into the
	 * memory at once?
	 * 
	 * Subscribe to see which companies asked this question
	 */

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> res = new ArrayList<Integer>();
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
		int[] r = new int[res.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = res.get(i);
		}
		return r;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.intersect(new int[] { 1, 2, 2, 1 }, new int[] {
				2, 2 })));
	}
}
