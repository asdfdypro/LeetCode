package asdf.test;

public class Solution2 {

	/**
	 * (发现出现一次的数 ) Given an array of integers, every element appears three times
	 * except for one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	// 本质上相同，每个位上，积攒3个归0
	public int singleNumber(int[] nums) {
		int one = 0, two = 0, three = 0; // 分别记录出现1次、2次、3次的位置
		for (int i = 0; i < nums.length; i++) {
			two |= one & nums[i];
			one ^= nums[i];
			three = one & two;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] nums = { 1, 3, 1, 1 };

		System.out.println(solution.singleNumber(nums));
	}
}
