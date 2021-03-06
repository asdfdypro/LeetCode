package asdf.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

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
	public int nthUglyNumber(int n) {
		Queue<Long> uglyHeap = new PriorityQueue<Long>();// 溢出 用long
		uglyHeap.offer(1l);
		long ugly = 0, t;
		while (n-- > n / 2) {
			ugly = uglyHeap.poll();
			t = ugly * 2;
			if (t > ugly && !uglyHeap.contains(t))// 注意重复和溢出
				uglyHeap.offer(t);
			t = ugly * 3;
			if (t > ugly && !uglyHeap.contains(t))
				uglyHeap.offer(t);
			t = ugly * 5;
			if (t > ugly && !uglyHeap.contains(t))
				uglyHeap.offer(t);
		}
		while (n-- > 0) {
			ugly = uglyHeap.poll();
		}

		return (int) ugly;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 20; i++) {
			System.out.println(i + "=" + solution.nthUglyNumber(i));
		}
		int i = 1407;
		System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 负数
		i = 1600;
		System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 小正数
	}
}
