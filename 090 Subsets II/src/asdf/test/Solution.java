package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (数组子集) Given a set of distinct integers, nums, return all possible
	 * subsets.
	 * 
	 * Note:
	 * 
	 * Elements in a subset must be in non-descending order. The solution set
	 * must not contain duplicate subsets.
	 * 
	 * For example, If nums = [1,2,3], a solution is:
	 * 
	 * [ [3],
	 * 
	 * [1],
	 * 
	 * [2],
	 * 
	 * [1,2,3],
	 * 
	 * [1,3],
	 * 
	 * [2,3],
	 * 
	 * [1,2],
	 * 
	 * [] ]
	 */
//先排序
	//重复的，并已经考虑的不再搜索
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int[] work = new int[nums.length];
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i <= work.length; i++) {
			res.addAll(combine(nums, work, i, 0));
		}
		return res;
	}

	// work 从b开始排列K个
	private List<List<Integer>> combine(int[] nums, int[] work, int k, int b) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < work.length; i++) {
				if (work[i] > 0)
					list.add(nums[i]);
			}
			res.add(list);
			return res;
		}

		for (int i = b; i < work.length; i++) {
			//重复的，并已经考虑的不再搜索
			if (i != 0 && nums[i] == nums[i - 1] && work[i - 1] == 0)
				continue;
			if (work[i] == 0) {
				work[i] = 1;
				res.addAll(combine(nums, work, k - 1, i + 1));
				work[i] = 0;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 2, 2,2 };
		List<List<Integer>> res = solution.subsetsWithDup(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}

	}
}
