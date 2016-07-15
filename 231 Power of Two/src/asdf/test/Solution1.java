package asdf.test;

public class Solution1 {

	/**
	 * (判断二的幂次方) Given an integer, write a function to determine if it is a
	 * power of two.
	 */
	public boolean isPowerOfTwo(int n) {
		if(n<=0)
			return false;
		return !((n&(n-1))>0);
	}

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
			
		System.out.println(solution.isPowerOfTwo(0));
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(solution.isPowerOfTwo(2));
		System.out.println(solution.isPowerOfTwo(3));
		System.out.println(solution.isPowerOfTwo(4));
	}
}
