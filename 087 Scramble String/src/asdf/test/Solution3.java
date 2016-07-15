package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

	/**
	 * (判断是否是交换字符串)Given two strings s1 and s2 of the same length, determine if
	 * s2 is a scrambled string of s1.
	 */

	// DP
	// f[k][i][j]表示 [i..i+k]与[j..j+k]是否匹配
	// f[k][i][j]=m in [1..k-1] {[m-1][i][j]&&[k-m-1][i+m][j+m]|| (f[m - 1][i][j + k - m] && f[k - m - 1][i + m][j]}
	//注意，k位置需要小的，所以k递增，i,j需要大的递减，
	//且i，j增加的与K有关，因此k要在最外面
	
	public boolean isScramble(String s1, String s2) {
		int len = s1.length();
		if (len != s2.length())
			return false;
		if (len == 0)
			return true;

		boolean[][][] f = new boolean[len][len][len];
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				f[0][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}

		for (int k = 2; k <= len; ++k) {
			for (int i = len - k; i >= 0; --i) {
				for (int j = len - k; j >= 0; --j) {
					boolean r = false;
					for (int m = 1; m < k && !r; ++m) {
						r = (f[m - 1][i][j] && f[k - m - 1][i + m][j + m])								
								|| (f[m - 1][i][j + k - m] && f[k - m - 1][i + m][j]);
					}
					f[k - 1][i][j] = r;
				}
			}
		}

		return f[len-1][0][0];
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();

		System.out.println(solution.isScramble("great", "rgtae"));
		System.out.println(solution.isScramble("bbbaa", "aabbb"));
		System.out.println(solution.isScramble("abab", "aabb"));
	}
}