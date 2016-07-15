package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution4 {
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
	// 改变中间结果的存储方式，依次递归存储，存储每次的链接信息，不能每次都构造字符串，否则超时

	// 6ms
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

		List<String>[] f = new List[sLen + 1];// 到i的位置能够拆分,当前位置的单词
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
						f[i].add(t);
					}
				}
			}
		}
		
		//处理结果
		List<String> res=new ArrayList<String>();
		List<String> work=new ArrayList<String>();
		output(res,work,f,sLen);		
		return res;
	}

	private void output(List<String> res, List<String> work, List<String>[] f, int sLen) {
		if (sLen <= 0) {
			StringBuffer sb = new StringBuffer(work.get(work.size() - 1));
			for (int i = work.size() - 2; i >= 0; i--) {
				sb.append(" ");
				sb.append(work.get(i));
			}
			res.add(sb.toString());
			return;
		}
		if (f[sLen] != null)
			for (String w : f[sLen]) {
				work.add(w);
				output(res, work, f, sLen - w.length());
				work.remove(work.size()-1);
			}
	}

	public static void main(String[] args) {
		Solution4 solution = new Solution4();
		String[] words = {"a","aa","c"};
		String s = "aa";
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
