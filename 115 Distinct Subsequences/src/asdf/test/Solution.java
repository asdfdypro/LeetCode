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
	 * (子串数目) Given a string S and a string T, count the number of distinct
	 * subsequences of T in S.
	 * 
	 * A subsequence of a string is a new string which is formed from the
	 * original string by deleting some (can be none) of the characters without
	 * disturbing the relative positions of the remaining characters. (ie, "ACE"
	 * is a subsequence of "ABCDE" while "AEC" is not).
	 * 
	 * Here is an example: S = "rabbbit", T = "rabbit"
	 * 
	 * Return 3.
	 */

	// 相当于S通过删除的方式，变成T
	public int numDistinct(String s, String t) {
		int lenS = s.length(), lenT = t.length();
		if (lenS == 0 || lenT == 0||lenS<lenT)
			return 0;
		int[][] f = new int[lenS + 1][lenT + 1];

		f[0][0] = 1;
		// 任意一个字符串变换成一个空串都只有一种变换方法
		for (int i = 0; i < lenS; i++) {
			f[i][0] = 1;
		}

		for (int i = 1; i <= lenS; i++) {
			for (int j = 1; j <= lenT; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
				} else {
					f[i][j] = f[i - 1][j];
				}
			}
		}

		return f[lenS][lenT];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.numDistinct("rabbbit", "rabbit"));
		System.out.println(solution.numDistinct("", "a"));
	}

}
