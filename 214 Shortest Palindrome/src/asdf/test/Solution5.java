package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5 {

	/**
	 * (最短回文串拼接) Given a string S, you are allowed to convert it to a palindrome
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

	// 贪心
	// 4 ms
	public String shortestPalindrome(String s) {
		int j = 0;

		for (int i = s.length() - 1; i >= 0; i--) {// 找到第一个使他不回文的位置，最少需要添加的字节数
			if (s.charAt(i) == s.charAt(j)) {
				j++;
			}
		}

		if (j == s.length()) { // 本身是回文
			return s;
		}

		String suffix = s.substring(j); // 后缀不能够匹配的字符串

		String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配

		String mid = shortestPalindrome(s.substring(0, j)); // 递归调用找
															// [0,j]要最少可以补充多少个字符让他回文

		String ans = prefix + mid + suffix;

		return ans;
	}

	public static void main(String[] args) {
		Solution5 solution = new Solution5();
		System.out.println(solution.shortestPalindrome("aacecaaa"));
		System.out.println(solution.shortestPalindrome("abcd"));
		System.out.println(solution.shortestPalindrome("a"));
		System.out.println(solution.shortestPalindrome("aa"));
		System.out.println(solution.shortestPalindrome("ab"));

		System.out.println(solution.shortestPalindrome("abbabaab"));
	}
}
