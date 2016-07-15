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
	// 二分查找 12ms
	public int hIndex(int[] citations) {
		int low = 0, high = citations.length - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (citations[mid] == citations.length - mid)
				return citations[mid];
			else if (citations[mid] < citations.length - mid)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return citations.length - (high + 1);
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
