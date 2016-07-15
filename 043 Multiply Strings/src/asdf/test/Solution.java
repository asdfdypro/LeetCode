package asdf.test;

public class Solution {

	/**
	 * (非负高精度乘法) Given two numbers represented as strings, return multiplication
	 * of the numbers as a string.
	 * 
	 * Note: The numbers can be arbitrarily large and are non-negative.
	 */

	public String sum(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
		StringBuffer sum = new StringBuffer();
		int c = 0;
		int i = len1 - 1, j = len2 - 1;
		while (i >= 0 && j >= 0) {
			c += num1.charAt(i--) - '0' + num2.charAt(j--) - '0';
			sum.insert(0, c % 10);
			c = c / 10;
		}
		while (i >= 0 && c > 0) {
			c += num1.charAt(i--) - '0';
			sum.insert(0, c % 10);
			c = c / 10;
		}
		if (i >= 0) {
			sum.insert(0, num1.substring(0, i + 1));
		}
		while (j >= 0 && c > 0) {
			c += num2.charAt(j--) - '0';
			sum.insert(0, c % 10);
			c = c / 10;
		}
		if (j >= 0) {
			sum.insert(0, num2.substring(0, j + 1));
		}
		if (c > 0)
			sum.insert(0, c);
		return sum.toString();
	}

	private String getTimes(String[] store, int time) {
		if (store[time] == null) {
			int m;
			switch (time) {
			case 2:
				store[time] = sum(store[1], store[1]);
				break;
			case 3:
				store[time] = sum(getTimes(store, 2), store[1]);
				break;
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				m = time / 2;
				store[time] = sum(getTimes(store, m), getTimes(store, time - m));
				break;
			}
		}
		return store[time];
	}

	public String multiply(String num1, String num2) {
		String[] store = new String[10];// 单倍结果
		store[0] = "0";
		store[1] = num1;

		String multiply = "0";
		int len2 = num2.length();
		StringBuffer time = new StringBuffer();
		String t;
		for (int i = len2 - 1; i >= 0; i--) {
			t = getTimes(store, num2.charAt(i) - '0');
			if (!"0".equals(t)) {
				multiply = sum(multiply, t + time.toString());
			}
			time.append('0');
		}
		return multiply;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.multiply("0", "52"));

		// for (int i = 0; i < 100; i++) {
		// for (int j = 0; j < 100; j++) {
		// if (solution.multiply(String.valueOf(i), String.valueOf(j)) .equals(
		// String
		// .valueOf(i * j)))
		// System.out.println(i + " * " + j + "="
		// + solution.multiply(String.valueOf(i), String.valueOf(j)));
		// }
		// }

	}

}
