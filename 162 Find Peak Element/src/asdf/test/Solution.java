package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (发现peek点 ) A peak element is an element that is greater than its
	 * neighbors.
	 * 
	 * Given an input array where num[i] ≠ num[i+1], find a peak element and
	 * return its index.
	 * 
	 * The array may contain multiple peaks, in that case return the index to
	 * any one of the peaks is fine.
	 * 
	 * You may imagine that num[-1] = num[n] = -∞.
	 * 
	 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
	 * should return the index number 2.
	 * 
	 * Your solution should be in logarithmic complexity.
	 */

	// 二分
	//输出序号
	public int findPeakElement(int[] nums) {
		return findPeakElement(nums, 0, nums.length - 1);
	}

	private int findPeakElement(int[] nums, int i, int j) {
		if (i == j)
			return i;
		if (j - i == 1)
			return nums[i] > nums[j] ? i: j;

		int m = (i + j) / 2;
		if (nums[m] > nums[m + 1] && nums[m] > nums[m - 1])
			return m;
		else if (nums[m] > nums[m + 1])
			return findPeakElement(nums, i, m - 1);
		else
			return findPeakElement(nums, m + 1, j);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 1 });
		list.add(new int[] { 1, 2, 3, 1 });
		list.add(new int[] { 1, 2, 3, 4 });
		list.add(new int[] { 4,3,2,1 });
		list.add(new int[] { 2,1 });
		list.add(new int[] { 1, 2});
		
		for (int[] is : list) {
			System.out.println(solution.findPeakElement(is));
		}

	}
}
