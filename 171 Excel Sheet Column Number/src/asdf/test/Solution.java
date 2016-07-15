package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (显示excel表头转换 )Given a column title as appear in an Excel sheet, return
	 * its corresponding column number.
	 * 
	 * For example:
	 * 
	 * A -> 1
	 * 
	 * B -> 2
	 * 
	 * C -> 3
	 * 
	 * ...
	 * 
	 * Z -> 26
	 * 
	 * AA -> 27
	 * 
	 * AB -> 28
	 */
	// 进制转化
	// 没有10
	public int titleToNumber(String s) {
		int len = s.length();
		int res = 0;
		for (int i = 0; i < len; i++) {
			res = res * 26 + s.charAt(i) - '@';
		}
		return res;
	}

	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();

		while (n > 0) {
			if (n % 26 == 0) {
				sb.append('Z');
				n = n / 26 - 1;
			} else {
				sb.append((char) (n % 26 + '@'));
				n /= 26;
			}
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i < 100; i++) {
			String g = solution.convertToTitle(i);
			int p = solution.titleToNumber(g);
			System.out.print(p);
			if (p != i)
				System.out.print("kk");
			System.out.println();
		}
	}
}
