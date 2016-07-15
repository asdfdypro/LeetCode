package asdf.test;

public class Solution {

	/**
	 * (安位翻转)Reverse bits of a given 32 bits unsigned integer.
	 * 
	 * For example, given input 43261596 (represented in binary as
	 * 00000010100101000001111010011100), return 964176192 (represented in
	 * binary as 00111001011110000010100101000000).
	 */

	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res = (res << 1) | (n & 1);
			n = n >> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverseBits(43261596));
		System.out.println(solution.reverseBits(0));
		System.out.println(solution.reverseBits(-1));
		System.out.println(solution.reverseBits(Integer.MAX_VALUE));
		System.out.println(solution.reverseBits(Integer.MIN_VALUE));
	}
}