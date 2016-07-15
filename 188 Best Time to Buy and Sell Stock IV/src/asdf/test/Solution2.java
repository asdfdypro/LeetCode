package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution2 {

	/**
	 * (最多k次串行股票买卖)Say you have an array for which the ith element is the price
	 * of a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * k transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
//local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
//global[i][j]=max(local[i][j],global[i-1][j])，
	public int maxProfit(int k, int[] prices) {

		if (k <= 0 || prices.length <= 0)
			return 0;

		// 加速，所有增加都能取到
		if (k >= prices.length / 2) {
			int result = 0;
			for (int i = 1; i < prices.length; ++i) {
				if (prices[i] - prices[i - 1] > 0) {
					result += prices[i] - prices[i - 1];
				}
			}
			return result;
		}

		int[][] f = new int[prices.length][k + 1];// 以i结尾的k个
		int[][] g = new int[prices.length][k + 1];// 到i为止的k个

		int diff;
		for (int i = 1; i < prices.length; i++) {// i
			for (int j = 1; j <= k; j++) {// k
				diff=prices[i]-prices[i-1];
				f[i][j]=Math.max(g[i-1][j-1]+Math.max(diff, 0),f[i-1][j]+diff);
				g[i][j]=Math.max(g[i-1][j],f[i][j]);
			}
		}

		return g[prices.length - 1][k];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.maxProfit(3, new int[] { 5, 6, 2, 8, 1, 9, 8, 7, 2, 6, 1 }));
	}

}
