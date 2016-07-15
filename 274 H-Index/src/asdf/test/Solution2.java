package asdf.test;

import java.util.Arrays;

public class Solution2 {

	/**
	 * (H值) Given an array of citations (each citation is a non-negative
	 * integer) of a researcher, write a function to compute the researcher's
	 * h-index.
	 * 
	 * According to the definition of h-index on Wikipedia:
	 * "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
	 * 
	 * For example, given citations = [3, 0, 6, 1, 5], which means the
	 * researcher has 5 papers in total and each of them had received 3, 0, 6,
	 * 1, 5 citations respectively. Since the researcher has 3 papers with at
	 * least 3 citations each and the remaining two with no more than 3
	 * citations each, his h-index is 3.
	 * 
	 * Note: If there are several possible values for h, the maximum one is
	 * taken as the h-index.
	 * 
	 * Hint:
	 * 
	 * An easy approach is to sort the array first. What are the possible values
	 * of h-index? A faster approach is to use extra space.
	 */
	// 计数 1ms
	public int hIndex(int[] citations) {
		int n = citations.length;
		int[] countArray = new int[n + 1];// 记录出现次数，最后一位记录大于n的

		// 统计个数，同时排序了
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n)
				countArray[n]++;
			else
				countArray[citations[i]]++;
		}

		if (countArray[n] >= n)
			return n;

		for (int i = n - 1; i >= 0; i--) {
			countArray[i] = countArray[i] + countArray[i + 1];
			if (countArray[i] >= i)
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.hIndex(new int[] { 3, 0, 6, 1, 5 }));
		System.out.println(solution.hIndex(new int[] {}));
		System.out.println(solution.hIndex(new int[] { 3 }));
		System.out.println(solution.hIndex(new int[] { 3, 4 }));

		System.out.println(solution.hIndex(new int[] { 0 }));// 边界
	}
}
