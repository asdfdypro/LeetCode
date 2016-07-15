package asdf.test;

public class Solution2 {

	/**
	 * (累计个位和求单位数) Given a non-negative integer num, repeatedly add all its
	 * digits until the result has only one digit.
	 * 
	 * For example:
	 * 
	 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has
	 * only one digit, return it.
	 * 
	 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
	 */
	// 有规律
	public int addDigits(int num) {

			return (num - 1) % 9 + 1;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		 for (int i = 0; i < 50; i++) {
		 System.out.println(solution.addDigits(i));
		 }
//		System.out.println(solution.addDigits(0));
//		System.out.println(solution.addDigits(38));
//		System.out.println(solution.addDigits(39));
	}
}
