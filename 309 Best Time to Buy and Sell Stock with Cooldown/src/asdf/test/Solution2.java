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
public class Solution2 {

    //采用状态机
    public int maxProfit(int[] prices) {

        if(prices.length<2)
            return 0;

        int[] emty=new int[prices.length];//空仓状态
        int[] full=new int[prices.length];//满仓状态
        int[] wait=new int[prices.length];//空仓代买状态

        emty[0]=0;
        full[0]=-prices[0];
        wait[0]=0;

        for (int i = 1; i < prices.length; i++) {
            emty[i]=Math.max(emty[i-1],wait[i-1]);
            full[i]=Math.max(emty[i-1]-prices[i],full[i-1]);
            wait[i]=full[i-1]+prices[i];

        }
        
        
        return Math.max(emty[prices.length-1], wait[prices.length-1]);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(new int[]{1, 2}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));

    }
}
