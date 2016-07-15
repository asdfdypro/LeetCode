package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (所有组合)
	 * 
	 * Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination
	 * should be a unique set of numbers.
	 * 
	 * Ensure that numbers within the set are sorted in ascending order.
	 * 
	 * Example 2:
	 * 
	 * Input: k = 3, n = 9
	 * 
	 * Output:
	 * 
	 * [[1,2,6], [1,3,5], [2,3,4]]
	 */
	// 先产生可能的数字
	// 再调用combination 2 的算法(只用一次) 增加位数约束
	private List<List<Integer>> combination2(int[] candidates, int target, int k, int i,
			Stack<Integer> work) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (i >= candidates.length || candidates[i] > target)
			return res;
		else if (k == 1) {
			for (int j = i; j < candidates.length; j++) {
				if (candidates[j] == target) {
					List<Integer> r = new ArrayList<Integer>(work);
					r.add(target);
					res.add(r);
				}
			}
		} else {
			int m;
			for (int j = i; j < candidates.length; j++) {
				if (candidates[j] > 0 && candidates[j] <= target) {
					if (j > 0 && candidates[j] == candidates[j - 1])// 相同，且前一个元素不再stack中，不再处理
						continue;
					m = candidates[j];
					candidates[j] = -1;
					work.push(m);
					res.addAll(combination2(candidates, target - m, k - 1, j + 1, work));// 下一个，去重
					work.pop();
					candidates[j] = m;
				}
			}
		}
		return res;
	}
//算法1 元素可以重复
//	private List<List<Integer>> combination1(int[] candidates, int target, int k, int i,
//			Stack<Integer> work) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//		if (target == 0 && k ==0)
//			res.add(new ArrayList<Integer>(work));
//		else if (i >= candidates.length || candidates[i] > target || k < 1)
//			return res;
//		else {
//			for (int j = i; j < candidates.length && candidates[j] <= target; j++) {
//				work.push(candidates[j]);
//				res.addAll(combination1(candidates, target - candidates[j], k - 1, j, work));
//				work.pop();
//			}
//		}
//		return res;
//	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] candidates;
		int maxN = n;
		if (maxN > 9) {
			maxN = 9;
		}
		candidates = new int[maxN];
		for (int i = 0; i < maxN; i++) {
			candidates[i] = i + 1;
		}
		return combination2(candidates, n, k, 0, new Stack<Integer>());

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> res = solution.combinationSum3(3, 7);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
			System.out.println();
		}
	}
}
