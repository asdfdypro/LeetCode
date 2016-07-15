package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3 {

	/**
	 * (二进制格雷码) The gray code is a binary numeral system where two successive
	 * values differ in only one bit.
	 * 
	 * Given a non-negative integer n representing the total number of bits in
	 * the code, print the sequence of gray code. A gray code sequence must
	 * begin with 0.
	 * 
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 
	 * 00 - 0
	 * 
	 * 01 - 1
	 * 
	 * 11 - 3
	 * 
	 * 10 - 2
	 * 
	 * 
	 * 
	 * Note: For a given n, a gray code sequence is not uniquely defined.
	 * 
	 * For example, [0,2,3,1] is also a valid gray code sequence according to
	 * the above definition.
	 * 
	 * For now, the judge is able to judge based on one instance of gray code
	 * sequence. Sorry about that.
	 */
	// 规律
	// 二进制数 变 二进制格雷码 ：二进制数右移一位，与原数异或
	public List<Integer> grayCode(int n) {

		// 特殊处理
		if (n < 1) {
			List<Integer> res = new ArrayList<Integer>(1);
			res.add(0);
			return res;
		}
		// 准备
		int size = 1 << n;
		List<Integer> res = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			res.add(i ^ i >> 1);
		}

		return res;
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		// 0,1,3,2,6,7,5,4
		List<Integer> res = solution.grayCode(3);
		for (Integer n : res) {
			System.out.println(n);
		}

	}
}