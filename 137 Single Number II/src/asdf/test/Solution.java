package asdf.test;

public class Solution {

	/**
	 * (发现出现一次的数 ) Given an array of integers, every element appears three times
	 * except for one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	// 本质上相同，每个位上，积攒3个归0
	public int singleNumber(int[] nums) {
		int[] bitnum = new int[Integer.SIZE];//记录每个位上1的个数
		int res = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			for (int j = 0; j < nums.length; j++) {
				bitnum[i] += (nums[j] >> i) & 1;
			}
			res |= (bitnum[i] % 3) << i;//每个位上模3
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 3, 1, 1 };

		System.out.println(solution.singleNumber(nums));
	}
}
