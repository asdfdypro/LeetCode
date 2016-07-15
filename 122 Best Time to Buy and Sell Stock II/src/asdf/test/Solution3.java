package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution3 {

	/**
	 * (多次串行股票买卖)Say you have an array for which the ith element is the price of
	 * a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	// 贪心
	// f[i]表示从0到i的最高利润
	// 考虑i-1和i两天
	// 若prices[i]>prices[i-1] 不论i-1有没有卖出，i-1到i买入都是合算的
	// 若prices[i]<prices[i-1] 不论i-1有没有卖出，i-1到i买入都是不合算的
	// 因此如果价格上涨持续买入，价格下跌全部卖出即可
	// 即：价格上涨累计涨幅即可
	public int maxProfit(int[] prices) {
		
		int maxPrice = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) 
				maxPrice+=prices[i]-prices[i-1];	
		}

		return maxPrice;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		int[] prices = { };

		System.out.println(solution.maxProfit(prices));

	}

}
