package asdf.test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * (罗马数字转数字)Given a roman numeral, convert it to an integer. Input is
	 * guaranteed to be within the range from 1 to 3999.
	 */
	private static Map<Character, Integer> tableMap = new HashMap<Character, Integer>();
	static {
		tableMap.put('I', 1);
		tableMap.put('V', 5);
		tableMap.put('X', 10);
		tableMap.put('L', 50);
		tableMap.put('C', 100);
		tableMap.put('D', 500);
		tableMap.put('M', 1000);
	}

	public int romanToInt(String s) {
		int len = s.length();
		if (len == 0) {
			return 0;
		}

		int num = 0;
		int m = tableMap.get(s.charAt(0));
		int pre = m;
		int now;
		for (int i = 1; i < len; i++) {
			now = tableMap.get(s.charAt(i));

			if (now > pre) {
				num += now - m;
				m = 0;
			} else if (now < pre) {
				num += m;
				m = now;
			} else {
				m += now;
			}
			pre = now;
		}
		num += m;
		return num;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		Test test=new Test();

		for (int i = 1; i < 4000; i++) {
			if (solution.romanToInt(test.intToRoman(i))!=i) {
				System.out.println(i);
			}			
		}
	}
}

class Test {
	private static String[][] table = {
			{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM" } };

	// 查表法 使用StringBuffer 16ms 使用String7ms 使用StringBuilder(线程不安全)7ms
	public String intToRoman(int num) {
		StringBuilder romanStr = new StringBuilder();
		int[] pos = new int[4];

		for (int i = 0; i < pos.length && num > 0; i++) {
			pos[i] = num % 10;
			num = num / 10;
		}
		for (int i = 3; i >= 0; i--) {
			romanStr.append(table[i][pos[i]]);
		}
		return romanStr.toString();
	}

}