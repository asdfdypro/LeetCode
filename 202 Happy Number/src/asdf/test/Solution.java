package asdf.test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	/**
	 * (幸运数)Write an algorithm to determine if a number is "happy".
	 * 
	 * A happy number is a number defined by the following process: Starting
	 * with any positive integer, replace the number by the sum of the squares
	 * of its digits, and repeat the process until the number equals 1 (where it
	 * will stay), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * 
	 */
	// 存在错误特例
	public boolean isHappy(int n) {
		Set<Integer> has = new HashSet<>();
		while (n != 1) {
			has.add(n);
			n = nextHappy(n);
			if (has.contains(n))
				return false;
		}
		return true;
	}

	public int nextHappy(int n) {
		int next = 0, mod;
		while (n > 0) {
			mod = n % 10;
			next += mod * mod;
			n /= 10;
		}
		return next;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isHappy(0));
		System.out.println(solution.isHappy(7));
		System.out.println(solution.isHappy(19));
	}
}