package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (字符串计算)Implement a basic calculator to evaluate a simple expression
	 * string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the
	 * plus + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * 
	 * "1 + 1" = 2
	 * 
	 * " 2-1 + 2 " = 3
	 * 
	 * "(1+(4+5+2)-3)+(6+8)" = 23
	 */
	public int calculate(String s) {

		boolean isPositive = true;
		Stack<Integer> stack = new Stack<Integer>();

		Integer c;
		int n;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				if (i - 1 >= 0 && s.charAt(i - 1) == '-')
					stack.push(Integer.MIN_VALUE);
				else
					stack.push(Integer.MAX_VALUE);
				isPositive = true;
				break;
			case ')':
				n = 0;
				c = stack.pop();
				while (c != Integer.MIN_VALUE && c != Integer.MAX_VALUE) {
					n += c;
					c = stack.pop();
				}
				if (c == Integer.MAX_VALUE)
					stack.push(n);
				else
					stack.push(-n);
				break;
			case '+':
				isPositive = true;
				break;
			case '-':
				isPositive = false;
				break;
			default:
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					n = s.charAt(i++) - '0';
					while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						n = n * 10 + s.charAt(i++) - '0';
					}
					i--;
					if (!isPositive)
						n = -n;
					stack.push(n);
				}
				break;
			}
		}

		n = 0;
		while (!stack.isEmpty()) {
			n += stack.pop();
		}
		return n;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.calculate("1 + 1"));
		System.out.println(solution.calculate(" 2-1 + 2 "));
		System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8) "));
		System.out.println(solution.calculate("(1-(4+5+2)-3)+(6+8) "));
		System.out.println(solution.calculate("(1) "));
		System.out.println(solution.calculate("9"));
		System.out.println(solution.calculate("-9"));
	}
}
