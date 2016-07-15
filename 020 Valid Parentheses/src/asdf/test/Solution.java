package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (括号匹配) Given a string containing just the characters '(', ')', '{', '}',
	 * '[' and ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			switch (s.charAt(i)) {
			case '{':
			case '[':
			case '(':
				stack.push(s.charAt(i));
				break;
			case ')':
				if (stack.size() == 0)
					return false;
				if (stack.pop() != '(')
					return false;
				break;
			case ']':
				if (stack.size() == 0)
					return false;
				if (stack.pop() != '[')
					return false;
				break;
			case '}':
				if (stack.size() == 0)
					return false;
				if (stack.pop() != '{')
					return false;
				break;

			default:
				return false;
			}
		}

		if (stack.size() > 0)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValid("(()"));

	}
}
