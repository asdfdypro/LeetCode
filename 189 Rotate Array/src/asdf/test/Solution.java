package asdf.test;

import java.util.Arrays;
import java.util.List;

public class Solution {

	/**
	 * (旋转数组 )Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4].
	 * 
	 * Note: Try to come up as many solutions as you can, there are at least 3
	 * different ways to solve this problem.
	 * 
	 * Could you do it in-place with O(1) extra space?
	 */
	// k可能大于nums.length
	// 以n-k为
	public void rotate(int[] nums, int k) {
		// int t;
		// for (int i = 0; i < nums.length - k % nums.length; i++) {
		// t = nums[0];
		// for (int j = 0; j < nums.length - 1; j++) {
		// nums[j] = nums[j + 1];
		// }
		// nums[nums.length - 1] = t;
		// }

		int length = nums.length;
		if (length == 1)
			return;
		k = k % length;		
		if (k == 0)
			return;

		rotate(nums, 0, length - k - 1);// 翻转前面的
		rotate(nums, length - k, length - 1);// 翻转后面的
		rotate(nums, 0, length - 1);// 整体翻转
	}

	private void rotate(int[] nums, int i, int j) {
		int t;
		while (i < j ) {
			t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = { 1, 2, 3 };
		solution.rotate(a, 1);
		System.out.println(Arrays.toString(a));

	}
}
