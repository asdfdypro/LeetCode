package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (满足登场单词组合的子串) You are given a string, s, and a list of words, words, that
	 * are all of the same length. Find all starting indices of substring(s) in
	 * s that is a concatenation of each word in words exactly once and without
	 * any intervening characters.
	 * 
	 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
	 * 
	 * You should return the indices: [0,9]. (order does not matter).
	 */

	// 由于word等长，只需考虑0-wordLen开始的串（其他的以考虑过）
	// 对每个穿，可以以wordLen*words的窗口扫描

	// 单词可能重复！！！

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		int wordLen = words[0].length();
		int windowEnd = s.length() - wordLen;

		int windowBegin;// 窗口头
		int windowLen = wordLen * words.length;// 窗口大小
		
		String nowWord;
		Integer count;

		Map<String, Integer> wordMap = new HashMap<String, Integer>(words.length);// 窗口中单词出现计数
		Map<String, Integer> wordStandardMap = new HashMap<String, Integer>(words.length);
		int wordCount;// 窗口中单词数目
		for (String word : words) {
			wordMap.put(word, 1);
			count=wordStandardMap.get(word);
			if(count==null)
				wordStandardMap.put(word, 2);//配合wordMap
			else
				wordStandardMap.put(word,count+1);
		}

		for (int i = 0; i < wordLen; i++) {// 可能的串起始点
			wordCount = 0;
			windowBegin = i;
			for (int j = i; j <= windowEnd; j += wordLen) {// 窗口尾
				if (j - windowBegin == windowLen) {
					nowWord = s.substring(windowBegin, windowBegin + wordLen);
					count = wordMap.get(nowWord);
					if (count != null) {// 存在
						if (count <= wordStandardMap.get(nowWord))// 比标准值小于等于，减少计数 
							wordCount--;
						wordMap.put(nowWord, count - 1);
					}
					windowBegin += wordLen;
				}// 窗口后移

				nowWord = s.substring(j, j + wordLen);
				count = wordMap.get(nowWord);
				if (count != null) {// 存在
					if (count <wordStandardMap.get(nowWord)) {
						wordCount++;
						if (wordCount == words.length) {
							res.add(windowBegin);
						}
					}
					wordMap.put(nowWord, count + 1);
				}
			}
			
			// 清理窗口
			for (; windowBegin <= windowEnd; windowBegin += wordLen) {//要清理到最后一个
				nowWord = s.substring(windowBegin, windowBegin + wordLen);
				count = wordMap.get(nowWord);
				if (count != null) {
					wordMap.put(nowWord, 1);
				}
			}			
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] words = { "foo", "bar" };
//		for (Integer n : solution.findSubstring("barfoothefoobarman", words)) {
//			System.out.println(n);
//		}
//
//		String[] words2 = { "word", "good", "best", "good" };
//		for (Integer n : solution.findSubstring("wordgoodgoodgoodbestword", words2)) {
//			System.out.println(n);
//		}
		
		String[] words3 = { "ba","bb"};
		for (Integer n : solution.findSubstring("baaacbabba", words3)) {
			System.out.println(n);
		}

	}
}
