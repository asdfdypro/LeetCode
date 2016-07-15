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
	 * (全排列) Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3]
	 * 
	 * have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
	 * [3,1,2], and [3,2,1].
	 */

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
				mask[i] = 1;
				work[length] = nums[i];
				res.addAll(permute(nums, work, mask, length + 1));
				mask[i] = 0;
			}
		}
		return res;
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int[] work = new int[nums.length];
		int[] mask = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			mask[i] = 1;
			work[0] = nums[i];
			res.addAll(permute(nums, work, mask, 1));
			mask[i] = 0;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] strs = {1,2,3,4  };

		List<List<Integer>> res = solution.permute(strs);

		System.out.println(res.size());

		for (List<Integer> list : res) {
			for (Integer string : list) {
				System.out.print(string + " , ");
			}
			System.out.println();
		}
	}

}
