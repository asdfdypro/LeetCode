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
	 * (杨辉三角的第k行)Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 */

	// 前序遍历
	public List<Integer> getRow(int rowIndex) {
		List<Integer> a = new ArrayList<Integer>();
		
		a.add(1);

		int m, l, t;
		List<Integer> b;
		for (int i = 0; i < rowIndex; i++) {
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
			a = b;
		}

		return a;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		List<Integer> list = solution.getRow(7);

		for (Integer integer : list) {
			System.out.print(integer);
		}

	}

}
