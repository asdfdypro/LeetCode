package asdf.test;

public class Solution {

	/**
	 * 如果第一个非空格字符存在，是数字或者正负号则开始做类型转换，之后检测到非数字(包括结束符 \0) 字符时停止转换，返回整型数。否则，返回零。
	 * 1、考虑不存在的情况 2、考虑只有符号的情况 3、考虑溢出
	 */
	public int myAtoi(String str) {
		int res = 0, i = 0, n;
		boolean negative = false;
		// 第一个不为空的字符
		while (i < str.length() && str.charAt(i) == ' ')
			i++;
		// 符号位
		if (i < str.length()) {
			if (str.charAt(i) == '+') {
				i++;
			} else if (str.charAt(i) == '-') {
				negative = true;
				i++;
			}
		}
		// 数字位
		for (; i < str.length(); i++) {
			n = str.charAt(i) - '0';
			if (n >= 0 && n <= 9) {				
				if ( res>(Integer.MAX_VALUE-n)/10) {// 溢出
					if (negative)
						res = -Integer.MIN_VALUE;
					else
						res = Integer.MAX_VALUE;
					break;
				}
				res = res * 10 + n;						
			} else {
				break;// 不是数字停止转换
			}
		}
		if (negative) {
			res = -res;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.myAtoi("b-2147483649"));
		System.out.println(solution.myAtoi("b123456789"));
		System.out.println(solution.myAtoi("123333333333333333333333333333"));

		System.out.println(solution.myAtoi("-1"));
		// System.out.println(2147483640+9);
		// Integer.valueOf("2147483649");
	}
}