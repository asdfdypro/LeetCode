package asdf.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	/**
	 * (求和结果) Given a string that contains only digits 0-9 and a target value,
	 * return all possibilities to add binary operators (not unary) +, -, or *
	 * between the digits so they evaluate to the target value.
	 * 
	 * Examples:
	 * 
	 * "123", 6 -> ["1+2+3", "1*2*3"]
	 * 
	 * "232", 8 -> ["2*3+2", "2+3*2"]
	 * 
	 * "105", 5 -> ["1*0+5","10-5"]
	 * 
	 * "00", 0 -> ["0+0", "0-0", "0*0"]
	 * 
	 * "3456237490", 9191 -> []
	 */
	
	//存在问题  0  乘法
	public List<String> addOperators(String num, int target) {
		Set<String> res = new HashSet<String>();
		for (int i = 1; i < num.length(); i++) {
			for (Formula a : addOperators(num.substring(0, i))) {
				for (Formula b : addOperators(num.substring(i))) {
					if (a.vaule + b.vaule == target)
						res.add(String.format("%s+%s", a.formula, b.formula));
					if (a.vaule - b.vaule == target)
						res.add(String.format("%s-%s", a.formula, b.formula));
					if (a.vaule * b.vaule == target)
						res.add(String.format("%s*%s", a.formula, b.formula));
				}
			}
		}
		return new ArrayList<>(res);
	}

	private List<Formula> addOperators(String num) {
		List<Formula> res = new ArrayList<Formula>();
		res.add(new Formula(num, Integer.valueOf(num)));
		for (int i = 1; i < num.length(); i++) {
			for (Formula a : addOperators(num.substring(0, i))) {
				for (Formula b : addOperators(num.substring(i))) {
					res.add(new Formula(String.format("%s+%s", a.formula, b.formula), a.vaule
							+ b.vaule));
					res.add(new Formula(String.format("%s-%s", a.formula, b.formula), a.vaule
							- b.vaule));
					res.add(new Formula(String.format("%s*%s", a.formula, b.formula), a.vaule
							* b.vaule));
				}
			}
		}
		return res;
	}

	class Formula {
		public String formula;
		public int vaule;

		public Formula(String formula, int vaule) {
			super();
			this.formula = formula;
			this.vaule = vaule;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		print(solution.addOperators("123", 6));
		print(solution.addOperators("232", 8 ));
		print(solution.addOperators("105", 5 ));
		print(solution.addOperators("00", 0 ));
		print(solution.addOperators( "3456237490", 9191 ));
	
	}

	private static void print(List<String> addOperators) {
		for (String string : addOperators) {
			System.out.print(string);
			System.out.print(',');
		}
		System.out.println();

	}
}
