package asdf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * (模式匹配)Given a pattern and a string str, find if str follows the same
	 * pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Examples:
	 * 
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	 * 
	 * pattern = "abba", str = "dog cat cat fish" should return false.
	 * 
	 * pattern = "aaaa", str = "dog cat cat dog" should return false.
	 * 
	 * pattern = "abba", str = "dog dog dog dog" should return false.
	 * 
	 * 
	 * Notes: You may assume pattern contains only lowercase letters, and str
	 * contains lowercase letters separated by a single space.
	 */
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (pattern.length() != strs.length)
			return false;
		String[] word = new String[26];
		Map<String, Integer> id = new HashMap<String, Integer>();
		int w;
		for (int i = 0; i < strs.length; i++) {
			w = pattern.charAt(i) - 'a';
			if (word[w] == null && id.get(strs[i]) == null) {
				word[w] = strs[i];
				id.put(strs[i], w);
			} else if (!(word[w] != null && id.get(strs[i]) != null && word[w].equals(strs[i]) && id
					.get(strs[i]) == w))
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
		System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
		System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
		System.out.println(solution.wordPattern("aaa", "aa aa aa aa"));
	}
}
