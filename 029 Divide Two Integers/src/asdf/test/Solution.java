package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	/**
	 * (实现除法) Divide two integers without using multiplication, division and mod
	 * operator.
	 * 
	 * If it is overflow, return MAX_INT.
	 */
	// 二分搜索
	// 考虑溢出情况---使用负数
	// 1、结果溢出：主要就是被除数是+-1的时候
	// 2、求和结果溢出，说明已经求得结果

	public int divide(int dividend, int divisor) {

		// overflow，1、结果溢出
		if (divisor == 1)
			return dividend;
		if (divisor == -1)
			if (dividend == Integer.MIN_VALUE)
				return Integer.MAX_VALUE;
			else
				return -dividend;

		// 处理符号
		boolean isPositive = true;
		if (dividend > 0) {
			isPositive = !isPositive;
			dividend = -dividend;
		}
		if (divisor > 0) {
			isPositive = !isPositive;
			divisor = -divisor;
		}

		// 做除法
		int res = 0, sum = 0, i = 0;
		List<Integer> d = new ArrayList<Integer>(32);
		List<Integer> r = new ArrayList<Integer>(32);
		d.add(divisor);
		r.add(-1);
		while (dividend <= sum) {
			while ((i > 0 && dividend > sum + d.get(i))||(i > 0 &&sum+ d.get(i) >= 0))
				i--;			
			sum += d.get(i);
			if (sum < 0)
				res += r.get(i);
			else
				break; // overflow，2、求和结果溢出

			// 调整
			if (i + 1 == d.size()&&d.get(i)  <<1<0) {				
				d.add(d.get(i) <<1);
				r.add(r.get(i) <<1);
				i++;
			}
		}		
		if(sum<0)
			res++;

		if (isPositive)
			res = -res;
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		for (int i = -100; i < 100; i++) {
			for (int j = -100; j < 100; j++) {
				if (j != 0) {
//					System.out.print(solution.divide(i, j));
//					System.out.print("===");
//					if (solution.divide(i, j) != i / j)
//						System.out.print(i + "/" + j + "=" + i / j);
//					System.out.println();
				}
			}
		}
//		 System.out.println(solution.divide(2147483647, 1));
//		 System.out.println(solution.divide(-2147483648, -1010369383));
//		 System.out.println(solution.divide(-1010369383, -2147483648));
//		 System.out.println(solution.divide(-2147483648, -1));
//		 System.out.println(solution.divide(-2147483648, 1));
		 System.out.println(solution.divide(-2147483648, 2));
		 System.out.println(solution.divide(2147483647,3));
		 System.out.println(solution.divide(-2147483648, -2147483648));
		
//		 System.out.println(-2147483648 + (-2147483648));
		 
		 System.out.println(3<<1);

		// int i=0;
		// while(true){
		// i+=10000;
		// System.out.println(i);
		// }

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}