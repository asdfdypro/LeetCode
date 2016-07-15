package asdf.test;

import java.util.Arrays;
import java.util.regex.Matcher;

public class Solution3 {

	/**
	 * (实现开平方) Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 */

	// 牛顿法, 	3 ms 
	public int mySqrt(int x) {
		   if (x ==0)  
	            return 0;  
	        double pre;  
	        double cur = 1;  
	        do  
	        {  
	            pre = cur;  
	            cur = x / (2 * pre) + pre / 2.0;  
	        } while (Math.abs(cur - pre) > 0.00001);  
		return (int) cur; 
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		for (int i = 0; i < 1000; i++) {
			int res = solution.mySqrt(i);
			int des = (int) Math.sqrt(i);
			if (res != des)
				System.out.println(i + " = " + res);
		}

		int i = 2147395599;
		int res = solution.mySqrt(i);
		int des = (int) Math.sqrt(i);
		if (res != des)
			System.out.println(i + " = " + res);
	}
}
