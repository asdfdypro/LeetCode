package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (颜色排序) Given an array with n objects colored red, white or blue, sort
	 * them so that objects of the same color are adjacent, with the colors in
	 * the order red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 * 
	 * Follow up:
	 * 
	 * A rather straight forward solution is a two-pass algorithm using counting
	 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
	 * overwrite array with total number of 0's, then 1's and followed by 2's.
	 * 
	 * Could you come up with an one-pass algorithm using only constant space?
	 */

	// 统计个数
	public void sortColors(int[] nums) {

		int a = 0, b = 0, c = 0;
		for (int i : nums) {
			switch (i) {
			case 0:
				a++;
				break;
			case 1:
				b++;
				break;
			case 2:
				c++;
				break;
			}
		}
		int j=0;
		for (int i=0; i < a; i++) {
			nums[j++]=0;
		}
		for (int i=0; i < b; i++) {
			nums[j++]=1;
		}
		for (int i=0; i <c; i++) {
			nums[j++]=2;
		}
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		int[] nums = { 1, 2, 0, 1, 2, 0, 0, 2, 1 };

		solution.sortColors(nums);
		System.out.println(Arrays.toString(nums));

	}

}
