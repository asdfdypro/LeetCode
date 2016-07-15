package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (组合和满足某个值) Given a set of candidate numbers (C) and a target number (T),
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note:
	 * 
	 * All numbers (including target) will be positive integers. Elements in a
	 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤
	 * a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations.
	 * 
	 * For example, given candidate set 2,3,6,7 and target 7, A solution set is:
	 * [7] [2, 2, 3]
	 */

	//结果集合非降序
	
	
	// 从candidates的i位置查target
	private List<List<Integer>> combination(int[] candidates, int target, int i, Stack<Integer> work) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(target==0)		
			res.add( new ArrayList<Integer>(work));		
		else if (i >= candidates.length || candidates[i] > target)
			return res;
		else if (candidates[i] == target) {//加速
			List<Integer> r = new ArrayList<Integer>(work);
			r.add(target);
			res.add(r);
		} else {
			for (int j = i; j < candidates.length && candidates[j] <= target; j++) {
				work.push(candidates[j]);
				res.addAll(combination(candidates, target-candidates[j], j, work));
				work.pop();
			}
		}
		return res;
	}

	//candidates无序但不重复
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combination(candidates, target, 0, new Stack<Integer>());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] candidates = { 2,3, 6, 7 };
		System.out.println(solution.combinationSum(candidates, 7).size());
	}

}
