package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * (括号组合 Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 */

	//回朔
	public void work(boolean isLeft, int l, int r, int n, StringBuffer work, Set<String> res) {
		if (isLeft && l > 0) {
			work.append('(');
			work(true, l - 1, r, n, work, res);
			work(false, l - 1, r, n, work, res);
			work.deleteCharAt(work.length() - 1);
		} else {
			if (r > 0&&r>l) {
				work.append(')');
				work(true, l, r - 1, n, work, res);
				work(false, l, r - 1, n, work, res);
				work.deleteCharAt(work.length() - 1);
			} else if(l==0) {
				res.add(work.toString());
			}
		}
	}

	public List<String> generateParenthesis(int n) {
		Set<String> res = new HashSet<>();
		StringBuffer work = new StringBuffer();
		work(true, n, n, n, work, res);		
		
		return new ArrayList(res);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String a="123";
		a=a.substring(0, a.length());
		System.out.println(a);

		System.out.println(solution.generateParenthesis(0).get(0));
		System.out.println(solution.generateParenthesis(1).get(0));
		System.out.println(solution.generateParenthesis(2).size());
		System.out.println(solution.generateParenthesis(3).size());
	}
}