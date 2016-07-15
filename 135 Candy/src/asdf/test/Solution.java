package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/**
	 * (分配糖果) There are N children standing in a line. Each child is assigned a
	 * rating value.
	 * 
	 * You are giving candies to these children subjected to the following
	 * requirements:
	 * 
	 * Each child must have at least one candy. Children with a higher rating
	 * get more candies than their neighbors.
	 * 
	 * What is the minimum candies you must give?
	 */
	
	// 比前一个大，多分一个
	// 比前一个小，分最少的
	//超时
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int j;
		int[] candy = new int[ratings.length];
		candy[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i - 1] + 1;// 多分1个
			else if (ratings[i] == ratings[i - 1])
				candy[i] = 1;// 相同，给一块
			else {
				candy[i] = 1;// 分最少的
				j = i - 1;
				while (j >= 0 && candy[j] == candy[j + 1]&&ratings[j]>ratings[j+1]) {
					candy[j]++;
					j--;
				}
			}
		}

		int sum = 0;
		for (int i : candy) {
			sum += i;
		}

		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] ratings={3,2,1};
//	int[] ratings ={51,87,87,72,12};
		int[] ratings ={5,1,1,1,10,2,1,1,1,3};
		System.out.println(solution.candy(ratings));
	}
}
