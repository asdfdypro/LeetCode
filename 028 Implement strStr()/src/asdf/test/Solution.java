package asdf.test;

public class Solution {

	/**
	 * (实现字符串查找功能) Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 */
	// 超时
	public int strStr(String haystack, String needle) {
		if (haystack.equals(needle))
			return 0;

		int haystackLen = haystack.length();
		int needleLen = needle.length();

		int j;
		for (int i = 0; i < haystackLen; i++) {
			for (j = 0; j < needleLen; j++) {
				if (haystack.charAt(i) != needle.charAt(j))
					break;
			}
			if (j == needleLen)
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.strStr("c", "c"));

	}

}
