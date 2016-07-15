package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

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
	
	//超时
	public int maxProfit(int k, int[] prices) {
		int[][] f = new int[prices.length][k + 1];// 以i结尾的k个

		int maxPrice, tPrice, minPrice, res = 0;

		for (int i = 1; i < prices.length; i++) {// i
			for (int j = 1; j <= k; j++) {// k
				maxPrice = f[i - 1][j] + prices[i] - prices[i - 1];
				minPrice = prices[i - 1];
				for (int t = i - 2; t >= 1; t--) {
					if (minPrice > prices[i])
						minPrice = prices[i];						
					tPrice = f[t][j - 1] + prices[i] - minPrice;
					if (tPrice > maxPrice)
						maxPrice = tPrice;
				}
				f[i][j] = maxPrice;
				if (maxPrice > res)
					res = maxPrice;
			}
		}

//		for (int i = 0; i < f.length; i++) {
//			System.out.print(prices[i] + "=  ");
//			for (int j = 0; j < f[0].length; j++) {
//				System.out.print(f[i][j]);
//				System.out.print(',');
//			}
//			System.out.println();
//		}

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.maxProfit(3, new int[] { 5, 6, 2, 8, 1, 9, 8, 7, 2, 6, 1 }));
	}

}
