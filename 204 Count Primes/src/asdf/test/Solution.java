package asdf.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	/**
	 * (统计质数个数)Count the number of prime numbers less than a non-negative
	 * number, n.
	 */
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		int primeCount = n - 2;
		int[] isPrime = new int[n];
		int k;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i] == 0) {
				k = i + i;
				while (k < n) {
					if (isPrime[k] == 0)
						primeCount--;
					isPrime[k] = 1;
					k += i;
				}
			}
		}
		return primeCount;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 13; i++) {
			System.out.println(i + "=" + solution.countPrimes(i));
		}

		System.out.println(solution.countPrimes(65));
	}
}
