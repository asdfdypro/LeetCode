package asdf.test;

import javax.sound.midi.Soundbank;

/**
 * (拆分数字 乘积最大)
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * <p>
 * Hint:
 * <p>
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 */
public class Solution {
    /**
     * 首先证明拆出的因子大于 4 是不行的。设 x 是一个因子，x>4，那么可以将这个因子再拆成两个因子 x−2 和 2，易证 (x−2)×2>x。所以不能有大于 4 的因子。
     * <p>
     * 4 这个因子也是可有可无的，4=2+2，4=2×2。因此 4 这个因子可以用两个 2 代替。
     * <p>
     * 除非没有别的因子可用，1 也不能选作因子。一个数 x 当它大于 3 时，有 (x−2)×2>(x−1)×1。
     * <p>
     * 这样呢，就只剩下 2 和 3 这两个因子可以选了。下面再证明 3 比 2 好。
     * <p>
     * 一个数 x=3m+2n，那么 f=3m×2n=3m×2x−3m2 可以对它取个对数。
     * lnf===mln3+nln2mln3+x−3m2ln2x2ln2+(ln3−32ln2)m
     * <p>
     * 其中 ln3−32ln2>0 所以 f 是 m 的增函数，也就是说 m 越大越好。所以 3 越多越好。
     * <p>
     * 再多说一句，如果拆出的因子不限于整数的话，可以证明e=2.718… 是最佳的选择。感兴趣的可以试着证明一下。
     *
     *
     * 也可以用均值不等式证明
     */
    public int integerBreak(int n) {
        if (n < 4) return n - 1;
        int res = 1;
        while (n > 2) {//看n包含多少个3,把他们相乘,直到n<=2
            res *= 3;
            n -= 3;
        }
        if (n == 0) return res;//n可以整除3，res就是各个3相乘
        if (n == 1) return (res / 3) * 4;//除3余1，把其中的一个3加1变为4再相乘
        if (n == 2) return res * 2;//除3余2,则可直接把2与res相乘

        return -1;//Error
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 2; i <= 58; i++) {
            System.out.println(solution.integerBreak(i));
        }
    }
}