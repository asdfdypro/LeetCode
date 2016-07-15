package asdf.test;

public class Solution {

	/**
	 * (. * 正则表达式)
	 * 
	 * '.' Matches any single character.
	 * 
	 * '*' Matches zero or more of the preceding element.
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples:
	 * 
	 * isMatch("aa","a") → false
	 * 
	 * isMatch("aa","aa") → true
	 * 
	 * isMatch("aaa","aa") → false
	 * 
	 * isMatch("aa", "a*") → true
	 * 
	 * isMatch("aa",".*") → true
	 * 
	 * isMatch("ab", ".*") → true
	 * 
	 * isMatch("aab", "c*a*b") → true
	 */
	// 考虑p+1位置是否为*，根据*对应的个数回朔查询
	// 使用一个表存储中间结果，减少回朔数目

	private int[][] ismatch;

	// 从posS和posP位置是否匹配
	public boolean isMatch(String s, String p, int lenS, int lenP, int posS, int posP) {
		// 先查询记录
		if (ismatch[posS][posP] > 0)
			return true;
		else if (ismatch[posS][posP] < 0)
			return false;

		boolean res;

		if (lenS == posS) {
			if (lenP == posP)
				res = true;
			else if (posP + 1 < lenP && p.charAt(posP + 1) == '*')
				res = isMatch(s, p, lenS, lenP, posS, posP + 2);
			else
				res = false;
		} else if (lenP == posP)
			res = false;
		else if (posP + 1 < lenP && p.charAt(posP + 1) == '*') {// 下一个是*
			boolean match = false;
			if (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '.') {
				match = isMatch(s, p, lenS, lenP, posS + 1, posP);// 匹配
			}
			if (match)
				res = true;
			else
				res = isMatch(s, p, lenS, lenP, posS, posP + 2);// 不匹配
		} else {
			if (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '.')
				res = isMatch(s, p, lenS, lenP, posS + 1, posP + 1);
			else
				res = false;
		}

		if (res)
			ismatch[posS][posP] = 1;
		else
			ismatch[posS][posP] = -1;
		return res;
	}

	public boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		ismatch = new int[lenS+1][lenP+1];
		return isMatch(s, p, lenS, lenP, 0, 0);
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		System.out.println(solution.isMatch("aa", ".*c"));
		System.out.println(solution.isMatch("", "c*a*b*"));
		System.out.println(solution.isMatch("ba", ".*"));
		System.out.println(solution.isMatch("aab", "c*a*b"));
		System.out.println(solution.isMatch("c", "c*"));
	}
}