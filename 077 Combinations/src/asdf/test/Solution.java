package asdf.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {

	/**
	 * (组合) Given two integers n and k, return all possible combinations of k
	 * numbers out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ [2,4],
	 * 
	 * [3,4],
	 * 
	 * [2,3],
	 * 
	 * [1,2],
	 * 
	 * [1,3],
	 * 
	 * [1,4], ]
	 */

	// 输出C(n,k) 回朔
	public List<List<Integer>> combine(int n, int k) {
		int[] work = new int[n];		
		return combine(work, k,0);
	}

	//work 从b开始排列K个
	private List<List<Integer>> combine(int[] work, int k,int b) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < work.length; i++) {
				if (work[i] > 0)
					list.add(i + 1);
			}
			res.add(list);
			return res;
		}

		for (int i = b; i < work.length; i++) {
			if (work[i] == 0) {
				work[i] = 1;
				res.addAll(combine(work, k - 1,i+1));
				work[i] = 0;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> res = solution.combine(4, 2);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
		
	}
}
