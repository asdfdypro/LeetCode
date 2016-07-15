package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (所有加括号的可能) Given a string of numbers and operators, return all possible
	 * results from computing all the different possible ways to group numbers
	 * and operators. The valid operators are +, - and *.
	 * 
	 * Example 1
	 * 
	 * Input: "2-1-1".
	 * 
	 * ((2-1)-1) = 0
	 * 
	 * (2-(1-1)) = 2
	 * 
	 * Output: [0, 2]
	 * 
	 * Example 2
	 * 
	 * Input: "2*3-4*5"
	 * 
	 * (2*(3-(4*5))) = -34
	 * 
	 * ((2*3)-(4*5)) = -14
	 * 
	 * ((2*(3-4))*5) = -10
	 * 
	 * (2*((3-4)*5)) = -10
	 * 
	 * (((2*3)-4)*5) = 10
	 * 
	 * Output: [-34, -14, -10, -10, 10]
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		char c;
		List<Integer> left, right;
		for (int i = 0; i < input.length(); i++) {
			switch (c = input.charAt(i)) {
			case '+':
			case '-':
			case '*':
				left = diffWaysToCompute(input.substring(0, i));
				right = diffWaysToCompute(input.substring(i + 1));
				for (Integer l : left) {
					for (Integer r : right) {
						switch (c) {
						case '+':
							res.add(l + r);
							break;
						case '-':
							res.add(l - r);
							break;
						case '*':
							res.add(l * r);
							break;
						}
					}
				}
				break;
			}
		}
		if (res.size() == 0 && input.length() > 0) {
			res.add(Integer.valueOf(input));
		}

		return res;
	}

	public static void main(String[] args) {

		solution("2-1-1");
		 solution("2*3-4*5");
		 solution("5");
		 solution("");
	}

	private static void solution(String input) {
		Solution solution = new Solution();
		List<Integer> res;
		res = solution.diffWaysToCompute(input);
		for (Integer integer : res) {
			System.out.print(integer);
			System.out.print(",");
		}
		System.out.println();
	}
}
