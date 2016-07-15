package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (实现开平方) Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 */

	//结果会溢出
	private int mySqrt(int x, int i, int j) {
		if (i >= j)
			if (i * i > x)// 返回小的
				return i - 1;
			else
				return i;

		int m = (i + j) / 2;//!!!!此处 溢出
		int mm = m * m;
		if (mm == x)
			return m;
		else if (mm > x)
			return mySqrt(x, i, m - 1);
		else
			return mySqrt(x, m + 1, j);
	}

	public int mySqrt(int x) {
		return mySqrt(x, 0, x);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 1000; i++) {
			int res = solution.mySqrt(i);
			int des = (int) Math.sqrt(i);
			if (res != des)
				System.out.println(i + " = " + res);
		}

		int i = 2147395599;
		int res = solution.mySqrt(i);
		int des = (int) Math.sqrt(i);
		if (res != des)
			System.out.println(i + " = " + res);
	}
}
