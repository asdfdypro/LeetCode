package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * (乘方运算) Implement pow(x, n).
	 */
	//6ms
	private Map<Integer, Double> pow;

	private double pow(double x, int n) {
		if (n < 1)//n=-2147483648的情况，特殊处理
			return 1.0;
		if (n == 1)
			return x;
		Double res = pow.get(n);
		if (res != null)
			return res;

		int m = n / 2;
		res = pow(x, m) * pow(x, n - m);
		pow.put(n, res);
		return res;
	}

	public double myPow(double x, int n) {
		if (n == 0)
			return 1.0;
		if (n == 1)
			return x;
		pow = new HashMap<Integer, Double>();
		if (n > 0)
			return pow(x, n);
		else
			return 1 / pow(x, -n);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		// System.out.println(solution.myPow(2,4));
		System.out.println(solution.myPow(	1.00000,
				-2147483648));
//		int n=-2147483648;
//		System.out.println(-n);
		
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				if (solution.myPow(i, j) - Math.pow(i, j) > 0.1)
//					System.out.println(i + " ^ " + j + "=" + solution.myPow(i, j));
//			}
//		}

	}

}
