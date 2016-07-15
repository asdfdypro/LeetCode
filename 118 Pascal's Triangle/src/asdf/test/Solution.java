package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (杨辉三角)Given numRows, generate the first numRows of Pascal's triangle.
	 * 
	 * For example, given numRows = 5, Return
	 * 
	 * [ [1],
	 * 
	 * [1,1],
	 * 
	 * [1,2,1],
	 * 
	 * [1,3,3,1],
	 * 
	 * [1,4,6,4,1] ]
	 */

	// 前序遍历
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (numRows > 0) {
			List<Integer> a = new ArrayList<Integer>();
			a.add(1);
			res.add(a);

			int m, l, t;
			List<Integer> b;
			for (int i = 1; i < numRows; i++) {
				b = new ArrayList<Integer>();
				b.add(1);
				m = a.get(0);
				l = a.size();
				for (int j = 1; j < l; j++) {
					t = a.get(j);
					b.add(t + m);
					m = t;
				}
				b.add(1);
				res.add(b);
				a = b;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		List<List<Integer>> r = solution.generate(4);
		for (List<Integer> list : r) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}

	}

}
