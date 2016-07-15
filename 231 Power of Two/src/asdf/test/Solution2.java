package asdf.test;

public class Solution2 {

	/**
	 * (判断二的幂次方) Given an integer, write a function to determine if it is a
	 * power of two.
	 */
	public boolean isPowerOfTwo(int n) {
		return n>0&&(1073741824%n==0);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int n=1;
		while(n*2>0)
			n*=2;
		System.out.println(n);
		
		System.out.println(solution.isPowerOfTwo(0));
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(solution.isPowerOfTwo(2));
		System.out.println(solution.isPowerOfTwo(3));
		System.out.println(solution.isPowerOfTwo(4));
	}
}
