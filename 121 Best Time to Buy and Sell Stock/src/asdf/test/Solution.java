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
	 * (一次股票买卖)Say you have an array for which the ith element is the price of a
	 * given stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 */
	// dp 记录最低售价与最高售价
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		int t;
		for (int p : prices) {
			t = p - minPrice;//此处可能溢出，需保证p>0
			if (t > maxProfit)
				maxProfit = t;
			if (p < minPrice)
				minPrice = p;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices = { -3,2,3};

		System.out.println(solution.maxProfit(prices));

	}

}
