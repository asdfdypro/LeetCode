package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/**
	 * (单词能否拆分)Given a string s and a dictionary of words dict, determine if s can
	 * be segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given
	 * 
	 * s = "leetcode",
	 * 
	 * dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */

	// DP
	public boolean wordBreak(String s, Set<String> wordDict) {

		int sLen = s.length();
		boolean[] f = new boolean[sLen+1];// 到i的位置能够拆分

		f[0] = true;
		for (int i = 1; i <= sLen; i++) {
			for (int j = i; j >= 0; j--) {
				if (f[j] && wordDict.contains(s.substring(j, i ))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[sLen];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = { "a", "b" ,"c"};
		String s = "abcd";
		Set<String> wordDict = new HashSet<String>();
		for (String w : words) {
			wordDict.add(w);
		}
		System.out.println(solution.wordBreak(s, wordDict));
	}

}
