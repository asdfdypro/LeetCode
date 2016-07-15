package asdf.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

	/**
	 * (第k个丑数) Write a program to find the n-th ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the
	 * first 10 ugly numbers.
	 * 
	 * Note that 1 is typically treated as an ugly number.
	 * 
	 * Hint:
	 * 
	 * The naive approach is to call isUgly for every number until you reach the
	 * nth one. Most numbers are not ugly.
	 * 
	 * Try to focus your effort on generating only the ugly ones. An ugly number
	 * must be multiplied by either 2, 3, or 5 from a smaller ugly number.
	 * 
	 * The key is how to maintain the order of the ugly numbers.
	 * 
	 * Try a similar approach of merging from three sorted lists: L1, L2, and
	 * L3. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 *
	 * 2, L2 * 3, L3 * 5).
	 */

	// 跟堆的算法类似，每次去的元素可以看做是，之前某个数与2 3 5的乘积
	// 只要记住上一个乘的位置就行
	public int nthUglyNumber(int n) {
		int t2 = 0, t3 = 0, t5 = 0;
		int[] k = new int[n];
		k[0] = 1;
		for (int i = 1; i < n; i++) {
			k[i] = Math.min(k[t2] * 2, Math.min(k[t3] * 3, k[t5] * 5));
			if (k[i] == k[t2] * 2)
				t2++;
			if (k[i] == k[t3] * 3)
				t3++;
			if (k[i] == k[t5] * 5)
				t5++;
		}
		return k[n - 1];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		for (int i = 1; i < 20; i++) {
			System.out.println(i + "=" + solution.nthUglyNumber(i));
		}
		int i = 1407;
		System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 负数
		i = 1600;
		System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 小正数
	}
}
