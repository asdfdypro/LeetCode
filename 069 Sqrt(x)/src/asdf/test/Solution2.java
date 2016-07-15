package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (实现开平方) Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 */

	// 改为非栈模式, 	3 ms 
	public int mySqrt(int x) {
		int i = 0, j = x;
		long m, mm;//防止溢出
		while (i < j) {
			m = (i + j) / 2;
			mm = m * m;
			if(m<0)
				break;
			if (mm == x)
				return (int) m;
			else if (mm > x)
				j = (int) (m - 1);
			else
				i = (int) (m + 1);
		}
		if (i * i > x)// 返回小的
			return i - 1;
		else
			return i;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
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
