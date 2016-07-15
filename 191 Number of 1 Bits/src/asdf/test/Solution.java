package asdf.test;

public class Solution {

	/**
	 * (计算1的个数)Write a function that takes an unsigned integer and returns the
	 * number of ’1' bits it has (also known as the Hamming weight).
	 * 
	 * For example, the 32-bit integer ’11' has binary representation
	 * 00000000000000000000000000001011, so the function should return 3.
	 */

	public int hammingWeight(int n) {
		int res = 0;
		while (n != 0) {
			res += n & 1;
			n = n >>> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight(43261596));
		System.out.println(solution.hammingWeight(0));
		System.out.println(solution.hammingWeight(-1));
		System.out.println(solution.hammingWeight(Integer.MAX_VALUE));
		System.out.println(solution.hammingWeight(Integer.MIN_VALUE));
	}
}