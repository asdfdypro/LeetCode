package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	/**
	 * (判断是否是交换字符串)Given two strings s1 and s2 of the same length, determine if
	 * s2 is a scrambled string of s1.
	 */

	// 遍历划分，超时
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

		if (len == 1)
			if (s1.equals(s2))
				return true;
			else
				return false;

		boolean r1, r2;
		int m;
		for (int pos = 1; pos < len; pos++) {
			m = len - pos;
			// 正对
			r1 = isScramble(dpMap, s1.substring(0, pos), s2.substring(0, pos), pos);
			if (r1) {
				r2 = isScramble(dpMap, s1.substring(pos, len), s2.substring(pos, len), m);
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
			r1 = isScramble(dpMap, s1.substring(0, pos), s2.substring(m, len), pos);
			if (r1) {
				r2 = isScramble(dpMap, s1.substring(pos, len), s2.substring(0, m), m);
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
		Solution2 solution = new Solution2();

		System.out.println(solution.isScramble("great", "rgtae"));
		System.out.println(solution.isScramble("bbbaa", "aabbb"));
		System.out.println(solution.isScramble("abab", "aabb"));
		System.out.println(solution.isScramble("abcdefghijklmn", "efghijklmncadb"));
	}
}