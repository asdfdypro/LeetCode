package asdf.test;

public class Solution2 {

	/**
	 * (实现字符串查找功能) Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 */

	// kmp
	public int strStr(String haystack, String needle) {

		int haystackLen = haystack.length();
		int needleLen = needle.length();
		if (needleLen == 0)
			return 0;

		int next[] = new int[needleLen + 1];// next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
		next[0] = next[1] = 0;

		int j = 0;
		for (int i = 1; i < needleLen; i++)// i表示字符串的下标，从0开始
		{// j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
			while (j > 0 && needle.charAt(i) != needle.charAt(j))
				j = next[j];
			if (needle.charAt(i) == needle.charAt(j))
				j++;
			next[i + 1] = j;
		}

		j = 0;
		for (int i = 0; i < haystackLen; i++) {
			while (j > 0 && haystack.charAt(i) != needle.charAt(j))
				j = next[j];
			if (haystack.charAt(i) == needle.charAt(j))
				j++;
			if (j == needleLen) {
				return i - j + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.strStr("ab", "ab"));

	}

}
