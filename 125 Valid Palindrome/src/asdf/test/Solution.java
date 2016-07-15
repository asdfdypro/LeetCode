package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (回文串判断) Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */

	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !isValid(s, i))
				i++;
			while (i < j && !isValid(s, j))
				j--;
			if (i < j) {
				if (isEquals(s, i, j)) {
					i++;
					j--;
				} else
					return false;
			}
		}
		return true;
	}

	// 字母是否有效
	public boolean isValid(String s, int pos) {
		char c = s.charAt(pos);
		return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}

	// 字母是否有效
	public boolean isEquals(String s, int i, int j) {
		return (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j)));
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(solution.isPalindrome(""));
		System.out.println(solution.isPalindrome(",."));
		System.out.println(solution.isPalindrome("race a car"));
		System.out.println(solution.isPalindrome("Aa"));
		System.out.println(solution.isPalindrome("0P"));

	}

}
