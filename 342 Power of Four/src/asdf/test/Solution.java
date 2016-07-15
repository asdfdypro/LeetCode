package asdf.test;

public class Solution {

	/**
	 * (判断四的幂次方) Given an integer (signed 32 bits), write a function to check whether it is a power of 4. 
	 */
	public boolean isPowerOfTwo(int num) {
		 return  num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n=1;
		while(n*4>0)
			n*=4;
		System.out.println(n);
		
		System.out.println(solution.isPowerOfTwo(0));
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(solution.isPowerOfTwo(2));
		System.out.println(solution.isPowerOfTwo(3));
		System.out.println(solution.isPowerOfTwo(4));
	}
}
