package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	/**
	 * (单词拆分结果)Given a string s and a dictionary of words dict, add spaces in s
	 * to construct a sentence where each word is a valid dictionary word.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given
	 * 
	 * s = "catsanddog",
	 * 
	 * dict = ["cat", "cats", "and", "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 */

	// DP
	//超时
	public List<String> wordBreak(String s, Set<String> wordDict) {

		int sLen = s.length();
		List<String>[] f = new List[sLen + 1];// 到i的位置能够拆分,拆分结果
		String t;
		f[0] = new ArrayList<String>();
		f[0].add("");
		for (int i = 1; i <= sLen; i++) {
			for (int j = i; j >= 0; j--) {
				t = s.substring(j, i);
				if (f[j] != null && wordDict.contains(t)) {
					if (f[i] == null) {
						f[i] = new ArrayList<String>();
					}
					for (String str : f[j]) {
						f[i].add(String.format("%s %s", str, t));
					}
				}
			}
		}
		return f[sLen];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = { "cat", "cats", "and", "sand", "dog" };
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<String>();
		for (String w : words) {
			wordDict.add(w);
		}
		List<String> res = solution.wordBreak(s, wordDict);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
