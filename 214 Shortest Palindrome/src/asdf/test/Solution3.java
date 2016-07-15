package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {

	/**
	 * (最短添加回文串) Given a string S, you are allowed to convert it to a palindrome
	 * by adding characters in front of it. Find and return the shortest
	 * palindrome you can find by performing this transformation.
	 * 
	 * For example:
	 * 
	 * Given "aacecaaa", return "aaacecaaa".
	 * 
	 * Given "abcd", return "dcbabcd".
	 */
	// 最短前缀回文串
	// 从头扩展

	// 使用KMP求最长回文 36ms
	
	public String shortestPalindrome(String s) {
		int sLen = s.length();

		int[] next = new int[sLen + 1];
		next[0] = -1;
		int q = -1;
		int p = 0;
		next[0] = -1;
		while (p < sLen) {
			if (q == -1 || s.charAt(p) == s.charAt(q)) {
				p++;
				q++;
				next[p] = q;
			} else {
				q = next[q];
			}
		}

		p = 0;
		q = sLen - 1;
		while (p < q) {
			if (s.charAt(p) == s.charAt(q)) {
				p++;
				q--;
			} else {
				p = next[p];
				if (p == -1){
					p=0;
					q--;
				}
			}
		}

		// 定位添加点
		if (p == q) {
			p = p * 2 + 1;
		} else {
			p = p * 2;
		}
		StringBuilder sb = new StringBuilder();
		while (p < sLen)
			sb.insert(0, s.charAt(p++));
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		System.out.println(solution.shortestPalindrome("aacecaaa"));
		System.out.println(solution.shortestPalindrome("abcd"));
		System.out.println(solution.shortestPalindrome("a"));
		System.out.println(solution.shortestPalindrome("aa"));
		System.out.println(solution.shortestPalindrome("ab"));
	}
}
