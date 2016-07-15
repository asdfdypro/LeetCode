package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

	/**
	 * (排序后的序列中两个相邻元素之间的最大差值 ) Given an unsorted array, find the maximum difference between
	 * the successive elements in its sorted form.
	 * 
	 * Try to solve it in linear time/space.
	 * 
	 * Return 0 if the array contains less than 2 elements.
	 * 
	 * You may assume all elements in the array are non-negative integers and
	 * fit in the 32-bit signed integer range.
	 */

	// 快排序
	//5ms
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		
		Arrays.sort(nums);
		int max=nums[1]-nums[0];
		int t;
		for (int i = 2; i < nums.length; i++) {
			t=nums[i]-nums[i-1];
			if(t>max)
				max=t;
		}
		return max;

	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 1 });
		list.add(new int[] { 1, 2, 3, 1 });
		list.add(new int[] { 1, 2, 3, 4 });
		list.add(new int[] { 4, 3, 2, 1 });
		list.add(new int[] { 2, 1 });
		list.add(new int[] { 1, 2 });

		for (int[] is : list) {
			System.out.println(solution.maximumGap(is));
		}

	}
}
