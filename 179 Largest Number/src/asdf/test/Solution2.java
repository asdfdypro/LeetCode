package asdf.test;

import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

	/**
	 * (最大组合数字 )Given a list of non negative integers, arrange them such that
	 * they form the largest number.
	 * 
	 * For example, given [3, 30, 34, 5, 9], the largest formed number is
	 * 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 */
	//
	// 直接组合比较
	// 0最小
	//129 ms 
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return -s1.compareTo(s2);
			}
		});
		
		StringBuffer sb = new StringBuffer();
		boolean isOut = false;
		for (String s : strs) {
			if (!"0".equals(s))
				isOut = true;
			sb.append(s);
		}
		if (isOut)
			return sb.toString();
		else
			return "0";
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.largestNumber(new int[] { 3, 30, 34, 5, 9 }));

		System.out.println(solution.largestNumber(new int[] { 524, 52, 5 }));

		System.out.println(solution.largestNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
		System.out.println(solution.largestNumber(new int[] { 121, 12 }));
		System.out.println(solution.largestNumber(new int[] { 8308, 830 }));
		System.out.println(solution.largestNumber(new int[] { 0, 0, 0 }));
	}
}
