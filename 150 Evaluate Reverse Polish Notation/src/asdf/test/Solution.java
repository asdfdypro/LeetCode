package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {

	/**
	 * (波兰表达式求值 ) Evaluate the value of an arithmetic expression in Reverse
	 * Polish Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Some examples:
	 * 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/",
	 * "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();

		int a, b;
		for (String str : tokens) {
			switch (str) {
			case "+":
				a = Integer.valueOf(stack.pop());
				b = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(b+a));
				break;
			case "-":
				a = Integer.valueOf(stack.pop());
				b = Integer.valueOf(stack.pop());
				stack.push(String.valueOf( b - a));
				break;
			case "*":
				a = Integer.valueOf(stack.pop());
				b = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(b * a));
				break;
			case "/":
				a = Integer.valueOf(stack.pop());
				b = Integer.valueOf(stack.pop());
				stack.push(String.valueOf(b / a));
				break;
			default:
				stack.push(str);
				break;
			}
		}
		return Integer.valueOf(stack.pop());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

//		String[] tokens = { "2", "1", "+", "3", "*" };
//		String[] tokens = {"4", "13", "5", "/", "+" };
//		String[] tokens = { "1","18","1","-","-" };
		String[] tokens = { "18","1","-",};
		System.out.println(solution.evalRPN(tokens));
	}
}
