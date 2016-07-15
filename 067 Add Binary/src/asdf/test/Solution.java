package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (高精度 二进制数相加) Given two binary strings, return their sum (also a binary
	 * string).
	 * 
	 * For example,
	 * 
	 * a = "11"
	 * 
	 * b = "1"
	 * 
	 * Return "100".
	 */

	public String addBinary(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		//补全
		if (aLen < bLen) {
			while(aLen++<bLen)
				a='0'+a;
			aLen--;
		} else if (aLen > bLen) {
			while(bLen++<aLen)
				b='0'+b;
			bLen--;
		}
		
		String res = "";
		int c = 0, i, j, k;
		while (--aLen >= 0 && --bLen >= 0) {
			i = a.charAt(aLen) - '0';
			j = b.charAt(aLen) - '0';
			res = (char)((i ^ j ^ c) + '0') + res;
			c = (i & j) | (i & c) | (j & c);
		}
		if (c > 0) {
			res = (char)(c + '0') + res;
		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				String res = Integer.toBinaryString(i + j);
				String des = solution.addBinary(Integer.toBinaryString(i),
						Integer.toBinaryString(j));
				if (!res.equals(des)) {
					System.out.println(i + " + " + j + " = " + des);
				}
			}
		}
	}
}
