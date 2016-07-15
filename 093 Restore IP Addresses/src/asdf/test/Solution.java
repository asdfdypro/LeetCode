package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	/**
	 * (合法IP地址)Given a string containing only digits, restore it by returning
	 * all possible valid IP address combinations.
	 * 
	 * For example: Given "25525511135",
	 * 
	 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 * 
	 */

	//三位时小于255
	//某位不能是0**
	
	// 从pos的位置开始，第n个段
	private void restore(List<String> res, String s, int len, String[] work, int pos, int n) {
		// 结束
		if (n == 4 && pos == len) {
			String ip = work[0];
			for (int i = 1; i < work.length; i++) {
				ip += "." + work[i];
			}
			res.add(ip);
			return;
		}
		// 继续
		if (n < 4 && pos < len) {// 取一个
			work[n] = s.substring(pos, pos + 1);
			restore(res, s, len, work, pos + 1, n + 1);

			if (pos + 1 < len&&s.charAt(pos) != '0') {// 取两个
				work[n] = s.substring(pos, pos + 2);
				restore(res, s, len, work, pos + 2, n + 1);

				if (pos + 2 < len
						&& (s.charAt(pos) < '2'
								|| (s.charAt(pos) == '2' && s.charAt(pos + 1) < '5') || (s
								.charAt(pos) == '2' && s.charAt(pos + 1) == '5' && s
								.charAt(pos + 2) < '6'))) {// 取三个
					work[n] = s.substring(pos, pos + 3);
					restore(res, s, len, work, pos + 3, n + 1);
				}
			}
		}

	}

	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		if (len >= 3 && len <= 12) {
			String[] work = new String[4];
			restore(res, s, len, work, 0, 0);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		List<String> head = solution.restoreIpAddresses("25525511135");
		for (String string : head) {
			System.out.println(string);
		}

		head = solution.restoreIpAddresses("010010");
		for (String string : head) {
			System.out.println(string);
		}

	}
}