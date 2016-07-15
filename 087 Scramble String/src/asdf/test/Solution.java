package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (判断是否是交换字符串)Given two strings s1 and s2 of the same length, determine if
	 * s2 is a scrambled string of s1.
	 */

	//只有居中划分，划分不正确
	public boolean isScramble(String s1, String s2) {
		int len1 = s1.length();
		if (len1 != s2.length())
			return false;
		if (len1 == 0)
			return true;
		Map<String, Map<String, Integer>> dpMap = new HashMap<String, Map<String, Integer>>();// 记录是否能转换
		return isScramble(dpMap, s1, s2, len1);
	}

	private boolean isScramble(Map<String, Map<String, Integer>> dpMap, String s1, String s2,
			int len) {
		Map<String, Integer> s1Map = dpMap.get(s1);
		if (s1Map != null) {
			if (s1Map.get(s2) != null)
				return s1Map.get(s2) > 0;
		}
		if (s1.equals(s2))
			return true;

		if (len == 1)
			return false;

		int m = len / 2;
		int t = len - m;
		// 正对
		boolean r1 = isScramble(dpMap, s1.substring(0, m), s2.substring(0, m), m);
		if (r1) {
			boolean r2 = isScramble(dpMap, s1.substring(m, len), s2.substring(m, len), t);
			if (r2) {
				if (s1Map == null)
					s1Map = new HashMap<>();
				s1Map.put(s1, 1);
				Map<String, Integer> s2Map = dpMap.get(s2);
				if (s2Map == null)
					s2Map = new HashMap<>();
				s2Map.put(s2, 1);
				return true;
			}
		}
		// 交换
		r1 = isScramble(dpMap, s1.substring(0, m), s2.substring(t, len), m);
		if (r1) {
			boolean r2 = isScramble(dpMap, s1.substring(m, len), s2.substring(0, t), t);
			if (r2) {
				if (s1Map == null)
					s1Map = new HashMap<>();
				s1Map.put(s1, 1);
				Map<String, Integer> s2Map = dpMap.get(s2);
				if (s2Map == null)
					s2Map = new HashMap<>();
				s2Map.put(s2, 1);
				return true;
			}
		}
		// 单数
		if (t != m) {
			// 正对
			r1 = isScramble(dpMap, s1.substring(0, t), s2.substring(0, t), t);
			if (r1) {
				boolean r2 = isScramble(dpMap, s1.substring(t, len), s2.substring(t, len), m);
				if (r2) {
					if (s1Map == null)
						s1Map = new HashMap<>();
					s1Map.put(s1, 1);
					Map<String, Integer> s2Map = dpMap.get(s2);
					if (s2Map == null)
						s2Map = new HashMap<>();
					s2Map.put(s2, 1);
					return true;
				}
			}
			// 交换
			r1 = isScramble(dpMap, s1.substring(0, t), s2.substring(m, len), t);
			if (r1) {
				boolean r2 = isScramble(dpMap, s1.substring(t, len), s2.substring(0, m), m);
				if (r2) {
					if (s1Map == null)
						s1Map = new HashMap<>();
					s1Map.put(s1, 1);
					Map<String, Integer> s2Map = dpMap.get(s2);
					if (s2Map == null)
						s2Map = new HashMap<>();
					s2Map.put(s2, 1);
					return true;
				}
			}
		}

		if (s1Map == null)
			s1Map = new HashMap<>();
		s1Map.put(s1, -1);
		Map<String, Integer> s2Map = dpMap.get(s2);
		if (s2Map == null)
			s2Map = new HashMap<>();
		s2Map.put(s2, -1);

		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isScramble("great", "rgtae"));
		System.out.println(solution.isScramble("bbbaa", "aabbb"));
		System.out.println(solution.isScramble("abab", "aabb"));
	}
}