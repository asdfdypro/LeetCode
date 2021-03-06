package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution1 {

	/**
	 * (字符串交叉组合) Given s1, s2, s3, find whether s3 is formed by the interleaving
	 * of s1 and s2.
	 * 
	 * For example,
	 * 
	 * Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true.
	 * 
	 * When s3 = "aadbbbaccc", return false.
	 * 
	 */

	// DP
	// 记录搜搜中的中间状态 10ms
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		Boolean[][][] f = new Boolean[len1 + 1][len2 + 1][len3 + 1];

		return isInterleave(f, s1, len1, 0, s2, len2, 0, s3, len3, 0);
	}

	// 分别从pos位置向下搜索
	private boolean isInterleave(Boolean[][][] f, String s1, int len1, int pos1, String s2,
			int len2, int pos2, String s3, int len3, int pos3) {
		// 终止条件
		if (pos3 == len3)
			if (pos1 == len1 && pos2 == len2)
				return true;
			else
				return false;

		// 查询
		if (pos1 < len1 && s1.charAt(pos1) == s3.charAt(pos3)) {
			if (f[pos1][pos2][pos3] == null)
				if (isInterleave(f, s1, len1, pos1 + 1, s2, len2, pos2, s3, len3, pos3 + 1)) {
					f[pos1][pos2][pos3] = true;
					return true;
				}// 不能false，下面还要搜索
		}

		if (pos2 < len2 && s2.charAt(pos2) == s3.charAt(pos3)) {
			if (f[pos1][pos2][pos3] == null)
				if (isInterleave(f, s1, len1, pos1, s2, len2, pos2 + 1, s3, len3, pos3 + 1)) {
					f[pos1][pos2][pos3] = true;
					return true;
				}
		}

		f[pos1][pos2][pos3] = false;
		return false;
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		System.out.println(solution.isInterleave("", "", ""));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
