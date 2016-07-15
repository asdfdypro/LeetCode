package asdf.test;

public class Solution {

	/**
	 * (判断是否字母个数相同) Given two strings s and t, write a function to determine if
	 * t is an anagram of s.
	 * 
	 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t =
	 * "car", return false.
	 * 
	 * Note: You may assume the string contains only lowercase alphabets.
	 * 
	 * Follow up: What if the inputs contain unicode characters? How would you
	 * adapt your solution to such case?
	 */
	public boolean isAnagram(String s, String t) {
		int[] countS = new int[26];
		int[] countT = new int[26];
		for (int i = 0; i < s.length(); i++) {
			countS[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			countT[t.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (countS[i] != countT[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();


		System.out.println(solution.isAnagram("anagram", "nagaram"));
		System.out.println(solution.isAnagram("rat", "car"));
	}
}
