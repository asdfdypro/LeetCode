package asdf.test;


import java.util.Arrays;

/**
 * (统计位数目)
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * <p>
 * Hint:
 * <p>
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 */
public class Solution2 {

    //DP 3ms
    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0, 1};
        int[] res = new int[num + 1];
        res[1]=1;
        int big = 2, small = 1;
        for (int i = 2; i <= num; i++) {
            if (i < big) {
                res[i] = res[i - small] + 1;
            } else {
                res[i] = 1;
                big <<= 1;
                    small <<= 1;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.countBits(10)));
    }
}

