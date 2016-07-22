package asdf.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * (超级丑数)
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * <p>
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class Solution {

    //伪堆
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] multiple = new int[primes.length];

        int[] ugly = new int[n];
        ugly[0] = 1;

        int pos, min, t;
        for (int i = 1; i < n; i++) {
            min = ugly[multiple[0]] * primes[0];
            for (int j = 1; j < primes.length ; j++) {
                t = ugly[multiple[j]] * primes[j];
                if (t < min) {
                    min = t;
                }
            }
            //相同的均要去除
            for (int j = 0; j < primes.length ; j++) {
                if(ugly[multiple[j]] * primes[j]==min)
                    multiple[j]++;
            }
            ugly[i]=min;
        }

        return ugly[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 15; i++) {
            System.out.println(solution.nthSuperUglyNumber(i + 1, new int[]{2, 7, 13, 19}));
        }
    }
}
