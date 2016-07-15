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
	 * (一次股票买卖)Say you have an array for which the ith element is the price of a
	 * given stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	// dp 记录最低售价与最高售价
	// 防止溢出
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		if (prices.length > 0) {
			int minPrice = prices[0];
			int t;
			for (int i = 1; i < prices.length; i++) {
				t = prices[i] - minPrice;
				if (t > maxProfit)
					maxProfit = t;
				if (prices[i] < minPrice)
					minPrice = prices[i];
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] prices = { -3, 2, 3 };

		System.out.println(solution.maxProfit(prices));

	}

}
