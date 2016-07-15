package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

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

	// 改进的桶排序
	// 从A到B，最多（B-A）/(LEN-1)个桶，最大差值在桶间

	// 3ms
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}

		// 计算个数
		int len =Math.max(1, (int)((max - min - 1) / (nums.length - 1)) + 1);// 桶宽度	
		int n = (max - min) / len + 1;// 桶数目
		int[] maxBucket = new int[n];// 桶的最大值
		int[] minBucket = new int[n];// 桶的最小值
		Arrays.fill(maxBucket, -1);

		// 放入桶中
		int pos;
		for (int i : nums) {
			pos = (i - min) / len;
			if (maxBucket[pos] == -1) {
				maxBucket[pos] = i;
				minBucket[pos] = i;
			} else {
				if (i > maxBucket[pos])
					maxBucket[pos] = i;
				if (i < minBucket[pos])
					minBucket[pos] = i;
			}
		}

		// 查询桶
		max = 0;
		min = maxBucket[0];
		for (int i = 1; i < maxBucket.length; i++) {
			if (maxBucket[i] != -1) {
				if (min == -1) {
					min = maxBucket[i];
				} else {
					pos = minBucket[i] - min;
					if (pos > max)
						max = pos;
					min = maxBucket[i];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { 1 });
		list.add(new int[] { 1, 2, 3, 1 });
		list.add(new int[] { 1, 2, 3, 4 });
		list.add(new int[] { 1, 1, 1, 1 });
		list.add(new int[] { 2, 4, 6, 8 });
		list.add(new int[] { 1, 2, 4 });

		for (int[] is : list) {
			System.out.println(solution.maximumGap(is));

		}

	}
}
