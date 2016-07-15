package asdf.test;

import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

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
	// 左对齐比较，先取大的
	// 相等的话，直接拼接比较
	// 0最小
	// 	141 ms 
	public String largestNumber(int[] nums) {
		Integer[] ns = new Integer[nums.length];
		for (int i = 0; i < ns.length; i++) {
			ns[i] = nums[i];
		}
		Arrays.sort(ns, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer();
				int i = o1, j = o2;
				// 处理0
				if (o1 == 0) {
					if (o2 != 0)
						return 1;
					else
						return 0;
				}
				if (o2 == 0) {
					if (o1 != 0)
						return -1;
					else
						return 0;
				}
				// 得到序列
				while (i > 0) {
					sb1.insert(0, i % 10);
					i /= 10;
				}
				while (j > 0) {
					sb2.insert(0, j % 10);
					j /= 10;
				}

				i = 0;
				j = 0;
				while (i < sb1.length() && j < sb2.length()) {
					if (sb1.charAt(i) > sb2.charAt(j)) {
						return -1;
					} else if (sb1.charAt(i) < sb2.charAt(j)) {
						return 1;
					} else {
						i++;
						j++;
					}
				}
				
				String t=sb1.toString();
				sb1.append(sb2);
				sb2.append(t);				
				return -sb1.toString().compareTo(sb2.toString());
			}
		});
		StringBuffer sb = new StringBuffer();
		boolean isOut = false;
		for (Integer integer : ns) {
			if (integer > 0)
				isOut = true;
			sb.append(integer);
		}
		if (isOut)
			return sb.toString();
		else
			return "0";
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.largestNumber(new int[] { 3, 30, 34, 5, 9 }));

		System.out.println(solution.largestNumber(new int[] { 524, 52, 5 }));

		System.out.println(solution.largestNumber(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
		System.out.println(solution.largestNumber(new int[] { 121, 12 }));
		System.out.println(solution.largestNumber(new int[] { 8308, 830 }));
		System.out.println(solution.largestNumber(new int[] { 0, 0, 0 }));
	}
}
