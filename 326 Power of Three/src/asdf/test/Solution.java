package asdf.test;

public class Solution {

	/**
	 * (判断三的幂次方) Given an integer, write a function to determine if it is a
	 * power of 3.
	 */
	public boolean isPowerOfTwo(int n) {
		 return n > 0 && (1162261467 % n == 0);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n=1;
		while(n*3>0)
			n*=3;
		System.out.println(n);
		
		System.out.println(solution.isPowerOfTwo(0));
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(solution.isPowerOfTwo(2));
		System.out.println(solution.isPowerOfTwo(3));
		System.out.println(solution.isPowerOfTwo(4));
	}
}
