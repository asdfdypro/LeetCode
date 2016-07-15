package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (数组子集) A message containing letters from A-Z is being encoded to numbers
	 * using the following mapping:
	 * 
	 * 'A' -> 1
	 * 
	 * 'B' -> 2
	 * 
	 * ...
	 * 
	 * 'Z' -> 26
	 * 
	 * 
	 * Given an encoded message containing digits, determine the total number of
	 * ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 */

	// DP 同上楼梯
	public int numDecodings(String s) {
		int len = s.length();
		if (len < 1)
			return 0;

		int[] f = new int[len];

		if (s.charAt(0) == '0')
			return 0;
		else
			f[0] = 1;
		char b, c;
		for (int i = 1; i < len; i++) {
			b = s.charAt(i);
			if (b == '0') {// 当前元素为0
				c = s.charAt(i - 1);
				if (c == '1' || c == '2')
					if (i == 1) {
						f[i] = 1;
					} else {
						f[i] = f[i - 2];
					}
				else
					return 0;// 字符串非法
			} else {
				c = s.charAt(i - 1);
				if (c == '1' || (c == '2' && b <= '6' && b >= '1'))
					if (i == 1)
						f[i] = f[i - 1] + 1;
					else
						f[i] = f[i - 1] + f[i - 2];
				else
					f[i] = f[i - 1];
			}
		}
		System.out.println(Arrays.toString(f));
		return f[len - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// System.out.println(solution.numDecodings("123433456326786429"));
		System.out.println(solution.numDecodings("0"));

	}
}
