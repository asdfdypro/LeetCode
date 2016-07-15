package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (转换小数 )Given two integers representing the numerator and denominator of a
	 * fraction, return the fraction in string format.
	 * 
	 * If the fractional part is repeating, enclose the repeating part in
	 * parentheses.
	 * 
	 * For example,
	 * 
	 * Given numerator = 1, denominator = 2, return "0.5".
	 * 
	 * Given numerator = 2, denominator = 1, return "2".
	 * 
	 * Given numerator = 2, denominator = 3, return "0.(6)".
	 */
	// 发现重复，需要记录余数，不能记录值
	// 负数， -0
	// 边界
	
	//使用StringBuffer 4ms string 5ms
	public String fractionToDecimal(int numerator, int denominator) {

		// 符号
		boolean f = true;
		long num=numerator,den= denominator;
		if (numerator < 0) {
			f = !f;
			num = -num;
		}
		if (denominator < 0) {
			f = !f;
			den = -den;
		}
		StringBuffer res = new StringBuffer();
		if (!f)
			res.append('-');

		long a = num / den;
		long b = num% den;
		if (b == 0)
			if (a == 0)
				return "0";//小心负0
			else
				return res + String.valueOf(a);

		Map<Long, Integer> map = new HashMap<Long, Integer>();// 从某个余数以及对应的位置
		res .append( String.valueOf(a));
		res.append('.');
		int n = res.length();
		Integer c;
		while (b != 0) {
			c = map.get(b);
			// 判断重复
			if (c != null) {
				return res.substring(0, c) + "(" + res.substring(c) + ")";
			} else {
				map.put(b, n++);
			}

			b = b * 10;
			a = b / den;
			b = b % den;
			res .append(String.valueOf(a));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.fractionToDecimal(1, 2));
		// System.out.println(solution.fractionToDecimal(2, 1));
		// System.out.println(solution.fractionToDecimal(4, 9));
		// System.out.println(solution.fractionToDecimal(4, 333));
//		System.out.println(solution.fractionToDecimal(1, 444));
//		System.out.println(solution.fractionToDecimal(1, 4444));
//		System.out.println(solution.fractionToDecimal(1, 444444));
//		System.out.println(solution.fractionToDecimal(3, 444));
//		System.out.println(solution.fractionToDecimal(-50, 8));
//		System.out.println(solution.fractionToDecimal(0, -8));
		System.out.println(solution.fractionToDecimal(-1, -2147483648));
	}
}
