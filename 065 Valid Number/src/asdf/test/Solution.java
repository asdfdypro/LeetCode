package asdf.test;

public class Solution {

	/**
	 * (验证是否是数字)Validate if a given string is numeric.
	 * 
	 * Some examples:
	 * 
	 * "0" => true
	 * 
	 * " 0.1 " => true
	 * 
	 * "abc" => false
	 * 
	 * "1 a" => false
	 * 
	 * "2e10" => true
	 * 
	 * Note: It is intended for the problem statement to be ambiguous. You
	 * should gather all requirements up front before implementing one.
	 */

	// 考虑为null的多种情况
	// 带e 指数必须为整数，必须有实部分
	// 考虑没有数字存在的 "." "+."

	public boolean isInteger(String s, boolean canNull) {
		
		if (!canNull&&("".equals(s) || ".".equals(s) || "+".equals(s) || "-".equals(s)))
			return false;

		int pos = -1, len = s.length();
		while (++pos < len) {
			if (pos == 0)
				if (s.charAt(pos) == '+' || s.charAt(pos) == '-')
					continue;
			if (s.charAt(pos) < '0' || s.charAt(pos) > '9')
				return false;
		}
		return true;
	}

	// 是否是数，不考虑e
	public boolean isRealNumber(String s) {

		//为空
		if ("".equals(s) || ".".equals(s) || "+".equals(s) || "-".equals(s))
			return false;

		int pos = s.indexOf('.');
		if (pos < 0) {
			return isInteger(s, true);
		} else {
			if (!isInteger(s.substring(0, pos), true))
				return false;
			// 小数，可以不存在
			int len = s.length();
			if (len - pos < 2) {// 小数不存在
				if (pos == 0)
					return false;
				if (pos == 1 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
					return false;
			}
			while (++pos < len)
				if (s.charAt(pos) < '0' || s.charAt(pos) > '9')
					return false;
			return true;
		}
	}

	public boolean isNumber(String s) {
		s = s.trim();

		int ePos = s.indexOf('e');
		if (ePos < 0) {
			return isRealNumber(s);
		} else {
			// 前面是实数，后面是整数
			return isRealNumber(s.substring(0, ePos)) && isInteger(s.substring(ePos + 1), false);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isNumber(".3e"));

	}

}
