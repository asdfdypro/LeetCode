package asdf.test;

public class Solution {

	/**
	 * (最大乘积子序列 ) Find the contiguous subarray within an array (containing at
	 * least one number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 */

	// 两点
	// 注意0！！！

	// 以0切分
	// 当没有负数时，为整体乘积
	// 当有偶数个时，为整体乘积
	// 当有奇数个时，为除去两遍一个负数后，最大乘积

	//2ms
	public int maxProduct(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		int i = 0, j = 0, max = 0;
		
		// 以0切分
		while (j < nums.length) {
			while (j < nums.length && nums[j] == 0)
				j++;
			i = j;
			while (j < nums.length && nums[j] != 0)
				j++;
			if (j < nums.length)
				max = Math.max(max, maxProduct(nums, i, j - 1));
		}
		if (nums[j - 1] != 0) {
			max = Math.max(max, maxProduct(nums, i, j - 1));
		}

		return max;
	}

	private int maxProduct(int[] nums, int i, int j) {
		if (i == j)
			return nums[j];

		int a = 1, b = 1, c = 1;
		// 左
		while (i <= j && a > 0) {
			a *= nums[i++];
		}
		// 右
		while (j >= i && c > 0) {
			c *= nums[j--];
		}
		// 中间
		while (i <= j) {
			b *= nums[i++];
		}

		// 全正
		if (a > 0)
			return a;
		// 1个负数
		if (c > 0) {
			a = a / nums[j];
			return Math.max(a, c);
		}
		// 偶数个负数
		if (b > 0)
			return a * b * c;
		// 奇数个负数
		return Math.max(a * b, b * c);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int[] nums = { -2 };
		// int[] nums = { -2,-2 };
		// int[] nums = { -2,-2,-2 };
		// int[] nums = { -2,-2,-2 ,-2};
		// int[] nums = { -2,-2,-2 ,2};
		// int[] nums = { 0, 1,0 };
		// int[] nums = { -1, 0,-2 };
		// int[] nums = { 0,-2 };
		int[] nums = { 3, 1, 0, 1 };
		System.out.println(solution.maxProduct(nums));

	}
}
