package asdf.test;

public class Solution {

	/**
	 * Reverse digits of an integer. //考虑溢出//考虑负数
	 */
	public int reverse(int x) {
		int res = 0, n;
		boolean negative = false;
		if (x < 0){negative = true;
			x = -x;}
		while (x != 0) {
			n = x % 10;
			if (res > (Integer.MAX_VALUE - n) / 10) {// 溢出
				res = 0;
				break;
			}
			res = res * 10 + n;
			x = x / 10;
		}
		 if (negative) {
			 res=-res;
		 }

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(0));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(Integer.MAX_VALUE));
		System.out.println(solution.reverse(Integer.MIN_VALUE));
	}
}