package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

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
	// 两端搜索
	
	//超时
	public String shortestPalindrome(String s) {
		int p = 0, q = s.length() - 1, nextq = q - 1;
		while (p < q) {
			if (s.charAt(p) == s.charAt(q)) {
				p++;
				q--;
			} else {
				p = 0;
				q = nextq--;
			}
		}
		
		// 定位添加点
		if (p == q) {
			p = p * 2 + 1;
		} else {
			p = p * 2;
		}
		StringBuilder sb = new StringBuilder();
		while (p < s.length())
			sb.insert(0, s.charAt(p++));
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.shortestPalindrome("aacecaaa"));
		System.out.println(solution.shortestPalindrome("abcd"));
		System.out.println(solution.shortestPalindrome("a"));
		System.out.println(solution.shortestPalindrome("aa"));
		System.out.println(solution.shortestPalindrome("ab"));
	}
}
