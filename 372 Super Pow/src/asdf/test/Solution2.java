package asdf.test;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * (快速计算幂次)
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example1:
 * <p>
 * a = 2
 * b = [3]
 * <p>
 * Result: 8
 * <p>
 * Example2:
 * <p>
 * a = 2
 * b = [1,0]
 * <p>
 * Result: 1024
 */
public class Solution2 {

    private final static int MOD = 1337;

    public int superPow(int a, int b) {
        int ans = 1;
        for (int i = 0; i < b; i++) ans = (ans * a) % MOD;
        return ans;
    }

    //(a*b)%c=(a%c)*(b%c)
    //x^670==POW(x^67,10)
    public int superPow(int a, int[] b) {
        int res = 1;
        a = a % MOD;

        for (int i =0; i <b.length; i++) {
            res=(superPow(res, 10) * superPow(a, b[i]))%MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        for (int i = 0; i < 50; i++) {
            System.out.println(solution.superPow(2, new int[]{i}));
        }

        System.out.println(solution.superPow(2, new int[]{1,2,3}));
        System.out.println(solution.superPow(2, new int[]{123}));

        System.out.println(solution.superPow(2147483647, new int[]{2, 0, 0}));

    }
}
