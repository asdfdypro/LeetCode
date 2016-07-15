package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (最少字符的字符串转变) Given two words word1 and word2, find the minimum number of
	 * steps required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * a) Insert a character
	 * 
	 * b) Delete a character
	 * 
	 * c) Replace a character
	 */
	// DP
	public int minDistance(String word1, String word2) {
		int iLen = word1.length(), jLen = word2.length();
		int[][] f = new int[iLen + 1][jLen + 1];
		f[0][0] = 0;
		for (int i = 1; i <= iLen; i++) {
			f[i][0] = f[i - 1][0] + 1;
		}
		for (int j = 1; j <= jLen; j++) {
			f[0][j] = f[0][j - 1] + 1;
		}
		for (int i = 1; i <= iLen; i++) {
			for (int j = 1; j <= jLen; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					f[i][j] = f[i - 1][j - 1];
				else
					f[i][j] = f[i - 1][j - 1] + 1;
				f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
				f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
			}
		}
		return f[iLen][jLen];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minDistance("", ""));
		System.out.println(solution.minDistance("a", ""));
		System.out.println(solution.minDistance("a", "a"));

	}
}
