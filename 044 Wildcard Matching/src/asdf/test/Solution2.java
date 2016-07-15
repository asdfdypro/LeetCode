package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	/**
	 * (通配符匹配)
	 * 
	 * '?' Matches any single character.
	 * 
	 * '*' Matches any sequence of characters (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples:
	 * 
	 * isMatch("aa","a") → false
	 * 
	 * isMatch("aa","aa") → true
	 * 
	 * isMatch("aaa","aa") → false
	 * 
	 * isMatch("aa", "*") → true
	 * 
	 * isMatch("aa", "a*") → true
	 * 
	 * isMatch("ab", "?*") → true
	 * 
	 * isMatch("aab", "c*a*b") → false
	 */

	// 使用贪心算法------》字符串只需要在第一次出现处匹配，*只需考虑最近的一个
	// 假设s上有c1，c2两个串可以与c匹配，c左右都有*，则c匹配c1即可，c2可以由右*匹配，反之c也可以匹配c2，c1由左*匹配，两者效果相同。

	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		int i = 0, j = 0, match = 0, asterisk = -1;
		while (i < m) {
			if (j < n && p.charAt(j) == '*') {
				match = i;// 记录出现*的位置
				asterisk = j++;
			} else if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (asterisk >= 0) {
				i = ++match;// 回跳*的位置，并依次向后移动
				j = asterisk + 1;
			} else
				return false;
		}
		while (j < n && p.charAt(j) == '*')
			j++;
		return j == n;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.isMatch("", ""));
		System.out.println(solution.isMatch("aa", "a"));
		System.out.println(solution.isMatch("a", "aa"));
		System.out.println(solution.isMatch("aa", "aa"));
		System.out.println(solution.isMatch("aaa", "aa"));
		System.out.println(solution.isMatch("aa", "*"));
		System.out.println(solution.isMatch("aa", "a*"));
		System.out.println(solution.isMatch("ab", "?*"));
		System.out.println(solution.isMatch("aab", "c*a*b"));
		System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
				"a*******b"));

		System.out.println(solution.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println(solution.isMatch("b", "?*?"));

		System.out.println(solution.isMatch("hi", "*?"));
	}
}
