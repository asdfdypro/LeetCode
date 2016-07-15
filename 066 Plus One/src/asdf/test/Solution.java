package asdf.test;

import java.util.Arrays;

public class Solution {

	/**
	 * (用数组表示的数加一)Given a non-negative number represented as an array of digits,
	 * plus one to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */

	// 考虑为null的多种情况
	// 带e 指数必须为整数，必须有实部分
	// 考虑没有数字存在的 "." "+."

	public int[] plusOne(int[] digits) {

		int c = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += c;
			c = digits[i] / 10;
			digits[i] %= 10;
			if(c==0)//加速
				break;
		}
		if(c>0){
			digits=new int[digits.length+1];
			digits[0]=1;
		}
		return digits;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] digits = { 8,9};
		System.out.println(Arrays.toString(solution.plusOne(digits)));

	}
}
