package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
	/**
	 * (查询主元素)Given an array of size n, find the majority element. The majority
	 * element is the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 * 
	 */
	// 找到两个不同的，成对删除
	 
	public int majorityElement(int[] nums) {
		int elem = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			if (count == 0) {//元素减光，重新选择
				elem = nums[i];
				count = 1;
			} else {
				if (elem == nums[i])
					count++;
				else
					count--;
			}

		}
		return elem;

	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 1 });
		list.add(new int[] { 2, 2 });
		list.add(new int[] { 1, 1, 2 });
		list.add(new int[] { 1, 1, 1, 2 });
		for (int[] is : list) {
			System.out.println(solution.majorityElement(is));
		}

	}
}
