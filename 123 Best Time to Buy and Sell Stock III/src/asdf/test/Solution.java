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
	 * (最多两次串行股票买卖)Say you have an array for which the ith element is the price
	 * of a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
	// 整个求解区间，依次划分为两个区间，求两个区间各自的最大利润的和，其中的最大值为两次买卖的最大值
	// 再求一次买卖的最大值，比较即可
	//正向 反向各走一遍，确定两头到切分点的最大利润
	public int maxProfit(int[] prices) {
		
		if (prices.length < 2)
			return 0;

		int[] maxPriceFromBegin = new int[prices.length];
		int[] maxPriceFromEnd = new int[prices.length];
		int t;
		
		//正向求最大利润
		int minPrice = prices[0];		
		for (int i = 1; i < prices.length; i++) {
			t = prices[i] - minPrice;
			if (t > maxPriceFromBegin[i-1])
				maxPriceFromBegin[i] = t;
			else
				maxPriceFromBegin[i] = maxPriceFromBegin[i-1];
			
			if (prices[i] < minPrice)
				minPrice = prices[i];
		}
		
		//反向求最大利润
		int maxPrice = prices[prices.length-1];
		for (int i =  prices.length-2; i >=0; i--) {
			t = maxPrice-prices[i];
			if (t > maxPriceFromEnd[i+1])
				maxPriceFromEnd[i] = t;
			else
				maxPriceFromEnd[i] = maxPriceFromEnd[i+1];
			
			if (prices[i] >maxPrice)
				maxPrice = prices[i];
		}
		
		//划分区间
		int max=maxPriceFromBegin[prices.length-1];
		for (int i = 1; i < prices.length-1; i++) {
			t=maxPriceFromBegin[i]+maxPriceFromEnd[i+1];
			if(t>max)
				max=t;
		}

		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] prices =
			{1,9,1,6,4,8,2};
//			{1,2,3};

		System.out.println(solution.maxProfit(prices));

	}

}
