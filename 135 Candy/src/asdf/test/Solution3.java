package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

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

	// 考虑上升，从1开始，每个大1
	// 考虑下降，每个小1，直到1，实际计算时，可以反过来从1开始累加
	// 从两个方向考虑，大于加一
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		for (int i = 1; i < candy.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = candy[i - 1] + 1;
		}
		for (int i = candy.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candy[i] = candy[i + 1] + 1>candy[i]? candy[i + 1] + 1:candy[i];//处理波峰
		}

		int sum = 0;
		for (int i : candy) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		// int[] ratings = {1,3,4,3,2,1 };
//		int[] ratings = { 1, 2 };
		// int[] ratings = {2,1};
		// int[] ratings = {1,2,2};
		// int[] ratings ={5,1,1,1,10,2,1,1,1,3};
		 int[] ratings ={51,87,87,72,12};
		System.out.println(solution.candy(ratings));
	}
}
