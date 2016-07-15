package asdf.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	/**
	 * (翻转元音) Write a function that takes a string as input and reverse only the
	 * vowels of a string.
	 * 
	 * Example 1: Given s = "hello", return "holle".
	 * 
	 * Example 2: Given s = "leetcode", return "leotcede".
	 */
	private static Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o',
			'u', 'A', 'E', 'I', 'O', 'U'));

	public String reverseVowels(String s) {

		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;
		char c;
		while (i < j) {
			while (i < j && !vowels.contains(chars[i]))
				i++;
			while (i < j && !vowels.contains(chars[j]))
				j--;
			if (i < j) {
				c = chars[i];
				chars[i] = chars[j];
				chars[j] = c;
				i++;
				j--;
			}
		}

		return new String(chars);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();	

		System.out.println(solution.reverseVowels(""));
		System.out.println(solution.reverseVowels("a"));
		System.out.println(solution.reverseVowels("aA"));//注意大小写
		System.out.println(solution.reverseVowels("ao"));
		System.out.println(solution.reverseVowels("t"));
		System.out.println(solution.reverseVowels("hello"));
		System.out.println(solution.reverseVowels("leetcode"));
	}
}
