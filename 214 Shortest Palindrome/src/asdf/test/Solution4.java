package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {

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

	// 使用KMP求最长回文 边走边建立 38 ms
	public String shortestPalindrome(String s) {
		int sLen = s.length();

		int p = 0;
		int k = -1;
		int q = sLen - 1;
		int[] next = new int[sLen + 1];
		next[0] = -1;
		while (p < q) {					
			if (s.charAt(p) == s.charAt(q)) {
				p++;
				q--;
				
				if (k == -1 || s.charAt(p-1) == s.charAt(k)) {			
					k++;
					next[p] = k;
				} else {
					k = next[k];
				}
				
				
			} else {
				p = next[p];
				if (p == -1){
					p=0;
					q--;
				}
				k=next[p];
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
		Solution4 solution = new Solution4();
		System.out.println(solution.shortestPalindrome("aacecaaa"));
		System.out.println(solution.shortestPalindrome("abcd"));
		System.out.println(solution.shortestPalindrome("a"));
		System.out.println(solution.shortestPalindrome("aa"));
		System.out.println(solution.shortestPalindrome("ab"));
		
		System.out.println(solution.shortestPalindrome("abbabaab"));
	}
}
