package asdf.test;

public class Solution2 {

	/**
	 * (最长公共子前缀)Write a function to find the longest common prefix string
	 * amongst an array of strings.
	 */
	// 采用另一种方式，时间相同
	//每个字符串和前缀比较

	public String longestCommonPrefix(String[] strs) {
		if (strs.length < 1)
			return "";

		int[] length = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			length[i] = strs[i].length();
		}

		String prefix = strs[0];
		int prefixLength = length[0], j;
		for (int i = 1; i < strs.length; i++) {			
			for (j = 0; j < prefixLength && j < length[i] && prefix.charAt(j) == strs[i].charAt(j); j++)
				;
			if (j < prefixLength) {
				prefix = prefix.substring(0, j);
				prefixLength = j;
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String[] a = { "aaadd", "aaab" };
		String[] b = {};

		System.out.println(solution.longestCommonPrefix(b));
		System.out.println(solution.longestCommonPrefix(a));
	}
}