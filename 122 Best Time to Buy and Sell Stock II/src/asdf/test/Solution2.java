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
	 * (多次串行股票买卖)Say you have an array for which the ith element is the price of
	 * a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 */
	// dp
	// f[i]表示从0到i的最高利润
	// f[i]=MAX{f[j]+prices[i]-prices[j],f[j]|0<=j<i}
	// 加速
	//如果连续两天的价格相同，收益相同
	public int maxProfit(int[] prices) {

		if (prices.length < 2)
			return 0;

		int[] f = new int[prices.length];
		int t, max;

		for (int i = 1; i < f.length; i++) {
			if (prices[i] == prices[i - 1])//加速
				f[i] = f[i - 1];
			else {
				max = 0;
				for (int j = 0; j < i; j++) {
					t = prices[i] - prices[j];
					if (t > 0)
						t += f[j];
					else
						t = f[j];
					if (t > max)
						max = t;
				}
				f[i] = max;
			}
		}

		return f[prices.length - 1];
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] prices = { 1, 2, 3, 1 };

		System.out.println(solution.maxProfit(prices));

	}

}
