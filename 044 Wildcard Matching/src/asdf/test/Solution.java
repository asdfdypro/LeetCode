package asdf.test;

public class Solution {

	/**
	 * (通配符匹配)
	 * 
	 * '?' Matches any single character.
	 * 
	 * '*' Matches any sequence of characters (including the empty sequence).
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
	 * isMatch("aa", "*") → true
	 * 
	 * isMatch("aa", "a*") → true
	 * 
	 * isMatch("ab", "?*") → true
	 * 
	 * isMatch("aab", "c*a*b") → false
	 */

	// 加速,必须用char
	private char[][] ismatch;

	// 从posS,posP开始是否匹配
	private boolean isMatch(String s, String p, int lenS, int lenP, int posS, int posP) {
		if (ismatch[posS][posP] =='1')
			return true;
		else if (ismatch[posS][posP] =='2')
			return false;

		
		boolean res;

		if (lenS == posS) {
			if (lenP == posP)
				res = true;
			else if (p.charAt(posP) == '*')
				res = isMatch(s, p, lenS, lenP, posS, posP + 1);
			else
				res = false;
		} else if (lenP == posP)
			res = false;
		else if (p.charAt(posP) == '*') {// 是*
			while (posP + 1 < lenP && p.charAt(posP + 1) == '*')
				posP++;
			
			if (isMatch(s, p, lenS, lenP, posS+1, posP + 1))// // 匹配1个
				res = true;
			else if (isMatch(s, p, lenS, lenP, posS, posP + 1))// 匹配0个
				res = true;
			else
				res = isMatch(s, p, lenS, lenP, posS + 1, posP);// 匹配多个
		} else {
			if (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '?') {
				res = isMatch(s, p, lenS, lenP, posS + 1, posP + 1);
			} else
				res = false;
		}
		if (res)
			ismatch[posS][posP] = '1';
		else
			ismatch[posS][posP]  ='2';
		return res;

	}

	public boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		ismatch = new char[lenS+1][lenP+1];
		return isMatch(s, p, lenS, lenP, 0, 0);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isMatch("", ""));
		System.out.println(solution.isMatch("aa", "a"));
		System.out.println(solution.isMatch("a", "aa"));
		System.out.println(solution.isMatch("aa", "aa"));
		System.out.println(solution.isMatch("aaa", "aa"));
		System.out.println(solution.isMatch("aa", "*"));
		System.out.println(solution.isMatch("aa", "a*"));
		System.out.println(solution.isMatch("ab", "?*"));
		System.out.println(solution.isMatch("aab", "c*a*b"));
		System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
				"a*******b"));
		
		System.out.println(solution.isMatch("abefcdgiescdfimde",
		"ab*cd?i*de"));
	}

}
