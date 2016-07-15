package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

	/**
	 * (字符串计算)Implement a basic calculator to evaluate a simple expression
	 * string.
	 * 
	 * The expression string contains only non-negative integers, +, -, *, /
	 * operators and empty spaces . The integer division should truncate toward
	 * zero.
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples:
	 * 
	 * "3+2*2" = 7
	 * 
	 * " 3/2 " = 1
	 * 
	 * " 3+5 / 2 " = 5
	 * 
	 * Note: Do not use the eval built-in library function.
	 */
	public int calculate(String s) {

		Queue<Integer> number = new LinkedList<>();
		Queue<Character> symbol = new LinkedList<>();

		int n;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				symbol.offer(s.charAt(i));
				break;
			default:
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					n = s.charAt(i++) - '0';
					while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
						n = n * 10 + s.charAt(i++) - '0';
					}
					i--;
					number.offer(n);
				}
				break;
			}
		}
		Stack<Integer> sum = new Stack<Integer>();
		sum.push(number.poll());
		while (!number.isEmpty()) {
			switch (symbol.poll()) {
			case '+':
				sum.push(number.poll());
				break;
			case '-':
				sum.push(-number.poll());
				break;
			case '*':
				sum.push(sum.pop() * number.poll());
				break;
			case '/':
				sum.push(sum.pop() / number.poll());
				break;
			}
		}

		n = 0;
		while (!sum.isEmpty()) {
			n += sum.pop();
		}

		return n;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.calculate("1 + 1"));
		System.out.println(solution.calculate(" 2-1 + 2 "));
		System.out.println(solution.calculate("3+2*2"));
		System.out.println(solution.calculate("3/2"));
		System.out.println(solution.calculate("3+5 / 2 "));
		System.out.println(solution.calculate("1*1-2*2"));
	}
}
