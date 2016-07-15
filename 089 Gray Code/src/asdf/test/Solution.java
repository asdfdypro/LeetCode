package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

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
	// 回朔
	// 从from开始
	private int work;
	private void code(List<Integer> res, int[] xor, int from) {
		if (from >= xor.length) {
			res.add(work);
			return;
		}

		code(res, xor, from + 1);//本位
		work ^= xor[from];
		code(res, xor, from + 1);//翻转

	}

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		// 特殊处理
		if (n < 1) {
			res.add(0);
			return res;
		}
		// 准备
		int[] xor = new int[n];
		int m = 1;
		for (int i = n - 1; i >= 0; i--) {
			xor[i] = m;
			m <<= 1;
		}
		// System.out.println(Arrays.toString(xor));

		work= 0;
		code(res, xor, 0);

		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 0,1,3,2,6,7,5,4
		List<Integer> res = solution.grayCode(5);
		for (Integer n : res) {
			System.out.println(n);
			// System.out.println(Integer.toBinaryString(n));
		}

	}
}
