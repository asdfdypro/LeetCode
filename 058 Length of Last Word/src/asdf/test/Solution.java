package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (最后一个字符串长度)Given a string s consists of upper/lower-case alphabets and
	 * empty space characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 */

	public int lengthOfLastWord(String s) {
		int len = s.length();
		int i = len - 1;
		// 末尾空格
		while (i >= 0 && s.charAt(i) == ' ')
			i--;
		int j = i;
		for (; i >= 0; i--) {
			if (s.charAt(i) == ' ')
				break;
		}
		return j - i;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLastWord(" 1   "));
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}
