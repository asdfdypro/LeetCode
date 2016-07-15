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
	 * (含重复元素的全排列) Given a collection of numbers that might contain duplicates,
	 * return all possible unique permutations.
	 * 
	 * For example, [1,1,2]
	 * 
	 * have the following unique permutations: [1,1,2], [1,2,1], and [2,1,1].
	 */

	//先排序，与前面元素相同不排序
	private List<List<Integer>> permute(int[] nums, int[] work, int[] mask, int length) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (length == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (Integer n : work) {
				list.add(n);
			}
			res.add(list);
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			if (mask[i] == 0) {
				if ( !(i > 0 && nums[i] == nums[i - 1]&&mask[i-1] == 0)) {// 过滤重复
					mask[i] = 1;
					work[length] = nums[i];
					res.addAll(permute(nums, work, mask, length + 1));
					mask[i] = 0;
				}
			}
		}
		return res;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] work = new int[nums.length];
		int[] mask = new int[nums.length];

		Arrays.sort(nums);// 先排序
		for (int i = 0; i < nums.length; i++) {
			if (!(i > 0 && nums[i] == nums[i - 1])) {// 过滤重复
				mask[i] = 1;
				work[0] = nums[i];
				res.addAll(permute(nums, work, mask, 1));
				mask[i] = 0;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] strs = {1,2,1 };

		List<List<Integer>> res = solution.permuteUnique(strs);

		System.out.println(res.size());

		for (List<Integer> list : res) {
			for (Integer string : list) {
				System.out.print(string + " , ");
			}
			System.out.println();
		}
	}

}
