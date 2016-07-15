package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (输出满足某个规律的数组) The count-and-say sequence is the sequence of integers
	 * beginning as follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211.
	 * 
	 * Given an integer n, generate the nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 */

	public String countAndSay(int n) {
		String s = "1";
		int len, m;
		String sb;
		char c;
		for (int i = 1; i < n; i++) {// 个数循环
			sb = "";
			len = s.length();
			m = 1;
			c = s.charAt(0);
			for (int j = 1; j < len; j++) {
				if (s.charAt(j) == c)
					m++;
				else {
					sb += m;
					sb += c;
					m = 1;
					c = s.charAt(j);
				}
			}
			sb += m;
			sb += c;
			s = sb;
		}
		return s;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		for (int i = 1; i < 10; i++) {
			System.out.println(solution.countAndSay(i));
		}

	}

}
