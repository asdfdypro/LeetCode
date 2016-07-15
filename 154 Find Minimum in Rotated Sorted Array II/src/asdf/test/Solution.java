package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (含有重复元素的旋转序列中，查找最小元素)Suppose a sorted array is rotated at some pivot
	 * unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element.
	 * 
	 * The array may contain duplicates.
	 * 
	 * 10,1,10,10,10 缩小范围！
	 * 
	 */
	// 二分查找
	public int findMin(int[] nums) {
		int i = 0, j = nums.length - 1, m;
		int min = nums[0];

		while (i < j) {
			// 两元素
			if (j - i == 1) {
				min = min < nums[j] ? min : nums[j];
				min = nums[i] < min ? nums[i] : min;
				break;
			}
			// 两头相等，缩小范围
			if (nums[i] == nums[j]) {
				i++;
				j--;
				continue;
			}

			m = (i + j) / 2;
			if (nums[i] <= nums[m]) {// 左面升序
				min = nums[i] < min ? nums[i] : min;
				i = m;
			} else {
//				min = nums[m + 1] < min ? nums[m + 1] : min;
				j = m;
			}
		}
		return nums[i] < min ? nums[i] : min;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		 int[][] nums = { { 4, 5, 6, 7, 0, 1, 2 }, { 1 }, { 1, 2 }, { 2, 1 },
		 { 1, 2, 3 },
		 { 3, 1, 2 }, { 2, 3, 1 }, { 1, 2, 3, 4 } };
		 for (int[] is : nums) {
		 System.out.println(solution.findMin(is));
		 }
		
		 int[][] nums2 = { { 1,1,1,1 }, { 1 }, { 1,1 }, { 1, 1, 3 },{ 3, 3, 1 },{ 3, 3,3, 1 }, { 10, 1, 10, 10, 10 },{ 3, 1,3},
		 { 3, 1, 1 }, { 1, 3, 1 }, { 1, 2, 1, 4 } };
		 for (int[] is : nums2) {
		 System.out.println(solution.findMin(is));
		 }
		

		int[] test = { 10, 1, 10 };
		System.out.println(solution.findMin(test));
	}
}
