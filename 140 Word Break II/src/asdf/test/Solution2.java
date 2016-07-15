package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
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
	// 剪枝，查找的长度在wordDict单词长度的范围内
	
	//超时
	public List<String> wordBreak(String s, Set<String> wordDict) {

		int sLen = s.length();
		int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE, wLen;
		for (String w : wordDict) {
			wLen = w.length();
			if (wLen > maxLen)
				maxLen = wLen;
			if (wLen < minLen) {
				minLen = wLen;
			}
		}

		List<String>[] f = new List[sLen + 1];// 到i的位置能够拆分,拆分结果
		String t;
		f[0] = new ArrayList<String>();
		f[0].add("");
		for (int i = 1; i <= sLen; i++) {
			for (int j = i; j >= 0; j--) {
				// 剪枝
				if (i - j < minLen)
					continue;
				if (i - j > maxLen)
					break;
				if (f[j] != null) {
					t = s.substring(j, i);
					if (wordDict.contains(t)) {
						if (f[i] == null) {
							f[i] = new ArrayList<String>();
						}
						for (String str : f[j]) {
							f[i].add(String.format("%s %s", str, t));
						}
					}
				}
			}
		}
		return f[sLen];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
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
