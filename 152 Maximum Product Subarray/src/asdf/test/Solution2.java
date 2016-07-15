package asdf.test;

public class Solution2 {

	/**
	 * (最大乘积子序列 ) Find the contiguous subarray within an array (containing at
	 * least one number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 */

	// 注意0！！！
	// DP
	// p到i的最大正数，o到i的最大负数
	// nums

	// 5 ms
	public int maxProduct(int[] nums) {

		int p = nums[0], o = nums[0], max = nums[0];
		int a,b;
		
		for (int i = 1; i < nums.length; i++) {
			 a = nums[i]*p;  
             b = nums[i]*o;  
             p = Math.max(Math.max(a,b), nums[i]);
             o = Math.min(Math.min(a,b), nums[i]);  
             max = Math.max(max, p);  
		}

		return max;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		// int[] nums = { -2 };
		// int[] nums = { -2,-2 };
		// int[] nums = { -2,-2,-2 };
		 int[] nums = { -2,-2,-2 ,-2};
//		 int[] nums = { -2,-2,-2 ,2};
		// int[] nums = { 0, 1,0 };
		// int[] nums = { -1, 0,-2 };
		// int[] nums = { 0,-2 };
//		int[] nums = { 3, 1, 0, 1 };
		System.out.println(solution.maxProduct(nums));

	}
}
