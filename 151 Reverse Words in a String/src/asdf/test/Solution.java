package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (反转单词串 ) Given an input string, reverse the string word by word.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 * 
	 * Clarification:
	 * 
	 * What constitutes a word?
	 * 
	 * A sequence of non-space characters constitutes a word.
	 * 
	 * Could the input string contain leading or trailing spaces?
	 * 
	 * Yes. However, your reversed string should not contain leading or trailing
	 * spaces.
	 * 
	 * How about multiple spaces between two words?
	 * 
	 * Reduce them to a single space in the reversed string.
	 */

	// 首尾空格
	// 中间空格
	public String reverseWords(String s) {
		String[] strs = s.trim().split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = strs.length - 1; i > 0; i--) {
			if (strs[i].length()>0&&strs[i].charAt(0)!=' ') {//空格串
				sb.append(strs[i]);
				sb.append(' ');
			}
		}
		if (strs.length > 0) {
			sb.append(strs[0]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.reverseWords(""));
		System.out.println(solution.reverseWords("    "));
		System.out.println(solution.reverseWords("the sky is blue"));
		System.out.println(solution.reverseWords("   the sky           is blue   "));
		System.out.println(solution.reverseWords(" 1"));
	}
}
