package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

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

	// 二分查找 nums1 nums2有序 nums1.length<<nums2.length
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		List<Integer> res = new ArrayList<Integer>();

		int pos = 0, p;
		for (int n : nums1) {
			p = Arrays.binarySearch(nums2, pos, nums2.length, n);
			if (p >= 0) {
				while (p >=pos && nums2[p] == n)//二分查找位置不确定
					p--;
				p++;
				if (nums2[p] == n) {
					pos = p + 1;
					res.add(n);
				}
			}
		}

		int[] r = new int[res.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = res.get(i);
		}
		return r;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		// System.out.println(Arrays.toString(solution.intersect(new int[] { 1,
		// 2, 2, 2, 1 },
		// new int[] { 2, 2 })));

		System.out.println(Arrays.toString(solution.intersect(new int[] { 54, 55, 55, 59, 60, 60,
				61, 61, 62, 64, 65, 67, 73, 76, 78 }, new int[] { 54, 55, 55, 59, 59, 60, 60, 61,
				62, 65, 66, 67, 68, 68, 69, 69, 71, 73, 74, 76, 80 })));
	}
}
