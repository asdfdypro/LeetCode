package asdf.test;

import java.util.Arrays;

/**
 * (选择硬币)
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {


    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;

        if (coins.length == 0)
            return -1;

        int[] f = new int[amount + 1];
        for(int i=1;i<f.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        for(int am=1;am<=amount;am++) {
            for(int i=0;i<coins.length;i++) {
                if(coins[i]<=am) {
                    int diff = am - coins[i];
                    if(f[diff] != Integer.MAX_VALUE) {
                        f[am] = Math.min(f[diff] +1, f[am]);
                    }
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
        System.out.println(solution.coinChange(new int[]{1}, 1));
        System.out.println(solution.coinChange(new int[]{2147483647}, 2));//小心溢出
    }
}
