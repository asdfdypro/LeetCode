package asdf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

	/**
	 * (字符串交叉组合) Given s1, s2, s3, find whether s3 is formed by the interleaving
	 * of s1 and s2.
	 * 
	 * For example,
	 * 
	 * Given: s1 = "aabcc", s2 = "dbbca",
	 * 
	 * When s3 = "aadbbcbcac", return true.
	 * 
	 * When s3 = "aadbbbaccc", return false.
	 * 
	 */

	// 搜索
	//超时
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (len1 + len2 != len3)
			return false;

		return isInterleave(s1, len1, 0, s2, len2, 0, s3, len3, 0);
	}

	// 分别从pos位置向下搜索
	private boolean isInterleave(String s1, int len1, int pos1, String s2, int len2, int pos2,
			String s3, int len3, int pos3) {
		// 终止条件
		if (pos3 == len3)
			if (pos1 == len1 && pos2 == len2)
				return true;
			else
				return false;

		// 查询
		if (pos1<len1&&s1.charAt(pos1) == s3.charAt(pos3)) {
			if (isInterleave(s1, len1, pos1 + 1, s2, len2, pos2, s3, len3, pos3 + 1))
				return true;
		}

		if (pos2<len2&&s2.charAt(pos2) == s3.charAt(pos3)) {
			if (isInterleave(s1, len1, pos1, s2, len2, pos2 + 1, s3, len3, pos3 + 1))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isInterleave("", "", ""));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
