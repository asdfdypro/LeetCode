package asdf.test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    /**
     * (第k个丑数) Write a program to find the n-th ugly number.
     * <p>
     * Ugly numbers are positive numbers whose prime factors only include 2, 3,
     * 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the
     * first 10 ugly numbers.
     * <p>
     * Note that 1 is typically treated as an ugly number.
     * <p>
     * Hint:
     * <p>
     * The naive approach is to call isUgly for every number until you reach the
     * nth one. Most numbers are not ugly.
     * <p>
     * Try to focus your effort on generating only the ugly ones. An ugly number
     * must be multiplied by either 2, 3, or 5 from a smaller ugly number.
     * <p>
     * The key is how to maintain the order of the ugly numbers.
     * <p>
     * Try a similar approach of merging from three sorted lists: L1, L2, and
     * L3. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 *
     * 2, L2 * 3, L3 * 5).
     */

    // 跟堆的算法类似，每次去的元素可以看做是，之前某个数与2 3 5的乘积
    // 只要记住上一个乘的位置就行
    public int nthUglyNumber(int n) {
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer> queue3 = new LinkedList<>();
        Queue<Integer> queue5 = new LinkedList<>();
        queue2.add(1);
        int val = 0, val2, val3, val5;

        for (int i = 0; i < n; i++) {
            val2 = queue2.size() == 0 ? Integer.MAX_VALUE : queue2.peek();
            val3 = queue3.size() == 0 ? Integer.MAX_VALUE : queue3.peek();
            val5 = queue5.size() == 0 ? Integer.MAX_VALUE : queue5.peek();

            val = Math.min(val2, Math.min(val3, val5));

            if (val == val2) {
                queue2.remove();
                if (2 * val > val)
                    queue2.add(2 * val);
                if (3 * val > val)
                    queue3.add(3 * val);
                if (5 * val > val)
                    queue5.add(5 * val);
            } else if (val == val3) {
                queue3.remove();
                if (3 * val > val)
                    queue3.add(3 * val);
                if (5 * val > val)
                    queue5.add(5 * val);
            } else {
                queue5.remove();
                if (5 * val > val)
                    queue5.add(5 * val);
            }
        }

        return val;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        for (int i = 1; i < 20; i++) {
            System.out.println(i + "=" + solution.nthUglyNumber(i));
        }
        int i = 1407;
        System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 负数
        i = 1600;
        System.out.println(i + "=" + solution.nthUglyNumber(i));// 溢出 小正数
    }
}
