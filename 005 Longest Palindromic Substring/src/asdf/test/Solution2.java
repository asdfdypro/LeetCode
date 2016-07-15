package asdf.test;

public class Solution2 {

	/**
	 * 最长回文子串 Given a string S, find the longest palindromic substring in S. You
	 * may assume that the maximum length of S is 1000, and there exists one
	 * unique longest palindromic
	 */
	// 采用从一个点，向外扩展的方式检查回文串，每个点之间不具有公共部分，检查数目最少
	// 每个点要检查两遍，一个是以自己为中间点，另一个是以自己和右面一个为中间点
	public String longestPalindrome(String s) {
		// 先处理特殊情况
		if (s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;

		int slength = s.length();
		int maxlength = 1, maxPos0 = 0, maxPos1 = 1; // 取最极端结果
		int length;

		for (int i = 0; i < slength; i++) {
			// 以此点为中间点
			length = 1;
			while (i - length >= 0 && i + length < slength
					&& s.charAt(i - length) == s.charAt(i + length)) {
				length++;
			}
			length--;
			if (2 * length + 1 > maxlength) {
				maxlength = 2 * length + 1;
				maxPos0 = i - length;
				maxPos1 = i + length;
			}
			
			// 以此点与右面一个点为中间点
			length=0;
			while (i - length >= 0 && i + length+1 < slength
					&& s.charAt(i - length) == s.charAt(i + length+1)) {
				length++;
			}
			length--;
			if (2 * length + 2 > maxlength) {
				maxlength = 2 * length + 2;
				maxPos0 = i - length;
				maxPos1 = i + length+1;
			}
		}

		return s.substring(maxPos0, maxPos1 + 1);
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();

		System.out.println(solution.longestPalindrome("a"));
		System.out.println(solution.longestPalindrome("aba"));
		System.out.println(solution.longestPalindrome("abba"));
		System.out.println(solution.longestPalindrome("abc"));
		// System.out.println("aaa".substring(0, 2));

	}
}