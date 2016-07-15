package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	/**
	 * (排序后的序列中两个相邻元素之间的最大差值 ) Given an unsorted array, find the maximum
	 * difference between the successive elements in its sorted form.
	 * 
	 * Try to solve it in linear time/space.
	 * 
	 * Return 0 if the array contains less than 2 elements.
	 * 
	 * You may assume all elements in the array are non-negative integers and
	 * fit in the 32-bit signed integer range.
	 */

	// 桶排序
	//6ms
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;

		sort(nums, 0x40000000, 0, nums.length - 1);

		int max = nums[1] - nums[0];
		int t;
		for (int i = 2; i < nums.length; i++) {
			t = nums[i] - nums[i - 1];
			if (t > max)
				max = t;
		}
		return max;
	}

	// 对n位中的i到j排序
	private void sort(int[] nums, int n, int i, int j) {

		if (n > 0 && j > i) {
			int t, p = i, q = j;
			while (i < j) {
				while (i < j && ((nums[i] & n) == 0))
					i++;
				while (i < j && ((nums[j] & n) != 0))
					j--;
				if (i < j) {
					t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
			while (p<=i&&(nums[i] & n) != 0)
				i--;
			sort(nums, n >>> 1, p, i);
			sort(nums, n >>> 1, i + 1, q);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 1 });
		list.add(new int[] { 1, 2, 3, 1 });
		list.add(new int[] { 1, 2, 3, 4 });
		list.add(new int[] { 4, 3, 2, 1 });
		list.add(new int[] { 2, 1 });
		list.add(new int[] { 1, 2 });

		for (int[] is : list) {			
			System.out.print(solution.maximumGap(is));
			System.out.print("=");
			System.out.print(Arrays.toString(is));
			System.out.println();
		}

	}
}
