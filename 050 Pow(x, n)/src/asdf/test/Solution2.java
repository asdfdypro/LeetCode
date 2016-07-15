package asdf.test;


public class Solution2 {

	/**
	 * (乘方运算) Implement pow(x, n).
	 */
	// 把n拆成2的幂的形式 1ms

	public double pow(double x, int n) {
		if (n < 1)//n=-2147483648的情况，特殊处理
			return 1.0;

		double ans = 1.0;
		for (; n > 0; x *= x, n >>= 1) {
			if ((n & 1) > 0)
				ans *= x;
		}
		return ans;
	}

	public double myPow(double x, int n) {
		if (n < 0)
			return 1.0 / pow(x, -n);
		else if (n > 0)
			return pow(x, n);
		else
			return 1.0;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		// System.out.println(solution.myPow(2,4));
		// System.out.println(solution.myPow(34.00515,-3));

		// System.out.println(solution.myPow(0.00001, 2147483647));
		System.out.println(solution.myPow(1.00000, -2147483648));

		// for (int i = 0; i < 100; i++) {
		// for (int j = 0; j < 100; j++) {
		// if (solution.myPow(i, j) - Math.pow(i, j) > 0.1)
		// System.out.println(i + " ^ " + j + "=" + solution.myPow(i, j));
		// }
		// }

	}
}
