package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution2 {

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
	// f[n][i]表示s3长为n时，s1包含i个，是够可以交叉组合
	// f[n][i]=f[n-1][i]&&s1[i]==s3[n] || f[n-1][i-1]&&s2[n-i]==s3[n]
	//7ms
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		boolean[][] f = new boolean[len3 + 1][len3 + 1];

		f[0][0] = true;

		for (int n = 1; n <= len3; n++) {
			for (int i = 0; i <= n && i <= len1; i++) {
				f[n][i] = (n - i - 1 < len2 && f[n - 1][i] && s2.charAt(n - i - 1) == s3
						.charAt(n - 1))// 从s2取
						|| (i > 0 && f[n - 1][i - 1] && s1.charAt(i - 1) == s3.charAt(n - 1));// 从s1取
			}
		}

		return f[len3][len1];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.isInterleave("", "", ""));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
