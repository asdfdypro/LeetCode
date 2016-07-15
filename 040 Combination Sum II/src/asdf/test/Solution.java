package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (组合和满足某个值,只使用一次) Given a collection of candidate numbers (C) and a target
	 * number (T), find all unique combinations in C where the candidate numbers
	 * sums to T.
	 * 
	 * Each number in C may only be used once in the combination
	 * 
	 * Note:
	 * 
	 * All numbers (including target) will be positive integers. Elements in a
	 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤
	 * a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations.
	 * 
	 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution
	 * set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
	 */

	// 结果中有重复

	private List<List<Integer>> combination(int[] candidates, int target, int i, Stack<Integer> work) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (target == 0)
			res.add(new ArrayList<Integer>(work));
		else if (i >= candidates.length || candidates[i] > target)
			return res;
		else if (candidates[i] == target) {//加速
			List<Integer> r = new ArrayList<Integer>(work);
			r.add(target);
			res.add(r);
		} else {
			int m;
			for (int j = i; j < candidates.length; j++) {
				if (candidates[j] > 0 && candidates[j] <= target) {
					if (j > 0 && candidates[j] == candidates[j - 1])// 相同，且前一个元素不再stack中，不再处理
						continue;
					m = candidates[j];
					candidates[j] = -1;
					work.push(m);
					res.addAll(combination(candidates, target - m, j + 1, work));// 下一个，去重
					work.pop();
					candidates[j] = m;
				}
			}
		}
		return res;
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);// 排序去重
		return combination(candidates, target, 0, new Stack<Integer>());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(solution.combinationSum2(candidates, 8).size());
		for (List<Integer> list : solution.combinationSum2(candidates, 8)) {
			for (Integer integer : list) {
				System.out.print(integer);
				System.out.print(',');
			}
			System.out.println();
		}
	}

}
