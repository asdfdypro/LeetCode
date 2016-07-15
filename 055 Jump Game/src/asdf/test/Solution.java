package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (是否能跳到末尾) Given an array of non-negative integers, you are initially
	 * positioned at the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 */

	//不能保证一定有解！！！不能遍历数组
	// dp 剪枝
	public boolean canJump(int[] nums) {
		if (nums.length < 2)
			return true;
		
		boolean[] f = new boolean[nums.length];// 是否能到达
		for (int i = 0; i <= nums[0]&&i<nums.length; i++) {
			f[i]=true;
		}
		
		
		int pos;
		int maxPos;
		int des = 0;// 当前最远距离，剪枝
		for (int i = 1; i < nums.length; i++) {			
			if(!f[i])//不能保证一定有解！！！跳出循环
				break;
			
			pos = i + 1;
			maxPos = nums[i] + i;
			// 加速
			if (des >= pos)
				pos = des + 1;
			if (maxPos > des)
				des = maxPos;

			for (; pos < nums.length && pos <= maxPos; pos++) {
				f[pos] = true;
			}

			// 加速
			if (pos == nums.length)
				break;
		}
		
		return f[nums.length - 1] ;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] matrix =
		// { 2, 1, 1, 1, 4 };
		// { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		// { 3, 2, 1, 0, 4 };
//		{ 5, 4, 3, 2, 1, 1, 0 };
		{1,1};
		boolean es = solution.canJump(matrix);

		System.out.println(es);

	}
}
