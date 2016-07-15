package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

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

	//超时
	public String shortestPalindrome(String s) {

		int sLen = s.length();
		int length;
		int maxlength = 0, pos = 0;

		for (int i = 0; i < sLen; i++) {
			// 以此点为中间点
			length = 1;
			while (i - length >= 0 && i + length < sLen
					&& s.charAt(i - length) == s.charAt(i + length)) {
				length++;
			}
			length--;
			if (length == i && 2 * length + 1 > maxlength) {// 取起始的
				maxlength = 2 * length + 1;
				pos = i + length;
			}

			// 以此点与右面一个点为中间点
			length = 0;
			while (i - length >= 0 && i + length + 1 < sLen
					&& s.charAt(i - length) == s.charAt(i + length + 1)) {
				length++;
			}
			length--;
			if (length == i && 2 * length + 2 > maxlength) {// 取起始的
				maxlength = 2 * length + 2;
				pos = i + length + 1;
			}
		}

		pos++;
		StringBuilder sb = new StringBuilder();
		while (pos < s.length())
			sb.insert(0, s.charAt(pos++));
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.shortestPalindrome("aacecaaa"));
		System.out.println(solution.shortestPalindrome("abcd"));
		System.out.println(solution.shortestPalindrome("a"));
		System.out.println(solution.shortestPalindrome("aa"));
		System.out.println(solution.shortestPalindrome("ab"));
	}
}
