package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (n阶乘中的0 )Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 * Note: Your solution should be in logarithmic time complexity.
	 */
	//2*5，2是足够的，主要看5的个数，每加5个出现一个5，同时积累5个多积一个5,依次类推
	//n!=2x*3y*5z*... 0的个数等于min(x,z)，并且min(x,z)==z

	public int trailingZeroes(int n) {
		n=n/5;
		int m=n;//5的个数
		while(n!=0){
			n=n/5;
			m+=n;
		}
		return m;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		long m = 1;
		for (int i = 1; i < 21; i++) {
			m *= i;
			System.out.print(i+"="+m + "=");
			int p = solution.trailingZeroes(i);
			System.out.println(p);
		}
		int t=0;
		System.out.println(t+"="+solution.trailingZeroes(t));
		t=26;
		System.out.println(t+"="+solution.trailingZeroes(t));
		 t=100;
		System.out.println(t+"="+solution.trailingZeroes(t));
		 t=100000;
		System.out.println(t+"="+solution.trailingZeroes(t));
	}
}
