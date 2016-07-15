package asdf.test;

public class Solution {

	/**
	 * (丑数) Write a program to check whether a given number is an ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 6, 8 are ugly while 14 is not ugly since it includes
	 * another prime factor 7.
	 * 
	 * Note that 1 is typically treated as an ugly number.
	 */
	public boolean isUgly(int num) {
		if (num < 1)
			return false;
//		if (num < 7)
//			return true;

		while (num % 2 == 0)
			num /= 2;
		if (num == 1)
			return true;

		while (num % 3 == 0)
			num /= 3;
		if (num == 1)
			return true;
		while (num % 5 == 0)			
			num /= 5;
		if (num == 1)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 20; i++) {
			System.out.println(i+"="+solution.isUgly(i));
		}
	}
}
