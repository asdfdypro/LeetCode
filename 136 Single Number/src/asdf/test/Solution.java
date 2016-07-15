package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (发现出现一次的数 ) Given an array of integers, every element appears twice
	 * except for one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
//迦罗瓦域加法
	public int singleNumber(int[] nums) {
		int res=0;
		for (int i : nums) {
			res^=i;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1,3,1 };
	
		System.out.println(solution.singleNumber(nums));
	}
}
