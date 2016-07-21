package asdf.test;

/**
 * (买卖股票,必须等待一天)
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * <p>
 * Example:
 * <p>
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class Solution {

    public int maxProfit(int[] prices) {

        if(prices.length<2)
            return 0;

        int[] f=new int[prices.length];//当天买的最大值
        int[] g=new int[prices.length];//当天休息的最大值
        int t;

        for (int i = 1; i < prices.length; i++) {
            g[i]=f[i-1]>g[i-1]?f[i-1]:g[i-1];

                f[i]=f[i-1]+prices[i]-prices[i-1];
                for (int j = 1; j < i; j++) {
                    t = prices[i] - prices[j]+g[j-1];
                    if (t > f[i])
                        f[i] = t;
                }
            }


        return f[prices.length-1]>g[prices.length-1]?f[prices.length-1]:g[prices.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));

    }
}
