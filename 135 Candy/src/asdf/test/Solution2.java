package asdf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

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
	//注意相等的情况，不是higher，不用保证大于，相当于重新开始，给一块！！！
	//注意交界点，对于波峰，要大于两遍的值，注意波峰可能出现在相等的位置
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int sum = 1, pre = 1;
		Boolean status = null;// true 增 false 减 null未定型
		Integer max=null;
		
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				if (status == null) {
					status = true;
				} else if (!status) {
					//考虑波峰
					if (max!=null&&pre>max) {
						sum+=pre-max;
					}					
					pre = 1;
					status = true;					
				}
				max=pre;//记录波峰的糖果数
			} else if (ratings[i] < ratings[i - 1]) {
				if (status == null) {
					status = false;
				} else if (status) {
					pre = 0;
					status = false;
				}			
			} else{
				if (max!=null&&pre>max&&!status) {
					sum+=pre-max;
				}						
				if (status == null) {
					pre = 0;
				} else if (status) {
					pre = 0;
				}else{
					pre = 0;
				}
				//重新开始
				status = null;
				max=null;
			}
			sum += ++pre;				
		}		
		//考虑波峰
		if (max!=null&&pre>max&&!status) {
			sum+=pre-max;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
//		int[] ratings = {1,3,4,3,2,1 };
		int[] ratings = {1,2};
//		int[] ratings = {2,1};
//		int[] ratings = {1,2,2};
//		int[] ratings ={5,1,1,1,10,2,1,1,1,3};
//	int[] ratings ={51,87,87,72,12};
		System.out.println(solution.candy(ratings));
	}
}
