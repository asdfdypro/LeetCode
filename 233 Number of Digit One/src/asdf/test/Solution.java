package asdf.test;

public class Solution {

	/**
	 * (统计1的个数)Given an integer n, count the total number of digit 1 appearing
	 * in all non-negative integers less than or equal to n.
	 * 
	 * For example: Given n = 13, Return 6, because digit 1 occurred in the
	 * following numbers: 1, 10, 11, 12, 13.
	 * 
	 * Hint:
	 * 
	 * Beware of overflow.
	 */
	// 按位考虑，
	// 个位，每10个出现1次
	// 十位，每100个出现10次
	// 百位，每1000个出现100次
	public int countDigitOne(int num) {

		int res = 0;
		int div,  mod;
		int last = 0,mul = 1;//零碎的1 倍数
		while (num > 0) {
			div = num / 10;
			mod = num % 10;

			res += div * mul;// 完整的倍数

			if (mod == 1)// 该位不满
				res += last+1;
			else if (mod > 1)// 该为已满
				res += mul;
			
			last += mod * mul;
			mul *= 10;
			num = div;
		}

		return res;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countDigitOne(-1));// 0
		System.out.println(solution.countDigitOne(0));// 0
		for (int i = 1; i < 25; i++) {
			System.out.println(i + "=" + solution.countDigitOne(i));
		}
		System.out.println(solution.countDigitOne(100));// 21
		System.out.println(Integer.MAX_VALUE + "="+solution.countDigitOne(Integer.MAX_VALUE));//-1323939513
	}
}
