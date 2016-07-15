package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (显示excel表头转换 )Given a positive integer, return its corresponding column
	 * title as appear in an Excel sheet.
	 * 
	 * For example:
	 * 
	 * 1 -> A
	 * 
	 * 2 -> B
	 * 
	 * 3 -> C
	 * 
	 * ...
	 * 
	 * 26 -> Z
	 * 
	 * 27 -> AA
	 * 
	 * 28 -> AB
	 */
	// 进制转化
	// 没有10
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
			System.out.println(solution.convertToTitle(i));
		}
	}
}
