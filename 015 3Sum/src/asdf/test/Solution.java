package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (三数和为0)Given an array S of n integers, are there elements a, b, c in S
	 * such that a + b + c = 0? Find all unique triplets in the array which
	 * gives the sum of zero.
	 * 
	 * Note: * Elements in a triplet (a,b,c) must be in non-descending order.
	 * (ie, a ≤ b ≤ c)
	 * 
	 * The solution set must not contain duplicate triplets.
	 */

	// 两层循环，遍历a,b,保存和，组成map，遍历c查询，时间n^2,超时
	class P {
		public int a, b, c;

		public P(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public P(int a, int b) {
			this.a = a;
			this.b = b;
			this.c = 0;
		}

		@Override
		public int hashCode() {
			return a + b + c;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			P other = (P) obj;
			if (a == other.a) {
				if (b == other.b && c == other.c)
					return true;
				if (b == other.c && c == other.b)
					return true;
			}
			if (b == other.b) {
				if (a == other.c && c == other.a)
					return true;
			}
			if (c == other.c) {
				if (a == other.b&& b == other.a)
					return true;
			}
			if(a==other.b&&b==other.c&&c==other.a)
				return true;
			if(a==other.c&&b==other.a&&c==other.b)
				return true;
			return false;
		}

		public List<Integer> getList() {
			List<Integer> list = new ArrayList<Integer>();
			list.add(a);
			list.add(b);
			list.add(c);
			Collections.sort(list);
			return list;
		}

		public boolean hasAB(int n) {
			return n == a || n == b;
		}
	}

	private void putMapSet(int n, P p, Map<Integer, Set<P>> sum2) {
		Set<P> set = sum2.get(n);
		if (set == null) {
			set = new HashSet<>();
			sum2.put(n, set);
		}
		set.add(p);
	}

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Map<Integer, Set<P>> sum2 = new HashMap<>();
		Set<P> resSet = new HashSet<>();

		Set<P> pSet;
		// 计算两个值解
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				putMapSet(nums[i] + nums[j], new P(i, j, -1), sum2);
			}
		}

		for (int k = 0; k < nums.length; k++) {
			pSet = sum2.get(-nums[k]);
			if (pSet != null)
				for (P p : pSet) {
					if (!p.hasAB(k)){						
						resSet.add(new P(nums[p.a], nums[p.b], nums[k]));
					}
				}
		}

		for (P p : resSet) {
//			System.out.println(p.a+"="+p.b+"="+p.c);
			res.add(p.getList());
		}

		return res;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] a = { 0, 0, 0, 0 };
		int[] b = { -1, 0, 1, 2, -1 };
		int[] c = { -1, 0, 1, 2, -1, -4, -1, 2, -2, 1, 3 };
		int[] d = { -5, 4, 5, -1, 3, 7, -8, -4, 7, -5, -4, 0, -9, -7, 7, -4, 1, -2, 3, 7, 4, 0, -3,
				3, -9, 5 };

		System.out.println(solution.threeSum(a).size());
		System.out.println(solution.threeSum(b).size());
		System.out.println(solution.threeSum(c).size());
		System.out.println(solution.threeSum(d).size());
	}
}
